/*
 * Copyright 2013-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.grails.plugins.tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Allows the tomcat server to be killed by pinging a port one greater than the server port.
 *
 * @author Graeme Rocher
 * @since 2.1
 */
public class TomcatKillSwitch implements Runnable {

    public static final String TOMCAT_KILL_SWITCH_ACTIVE = "TomcatKillSwitch.active";

    protected Tomcat tomcat;
    protected int serverPort;

    public TomcatKillSwitch(Tomcat tomcat, int serverPort) {
        this.tomcat = tomcat;
        this.serverPort = serverPort;
    }

    public static boolean isActive() {
        return Boolean.getBoolean("TomcatKillSwitch.active");
    }

    public void run() {
        System.setProperty("TomcatKillSwitch.active", "true");
        int killListenerPort = serverPort + 1;
        ServerSocket serverSocket = createKillSwitch(killListenerPort);
        if (serverSocket != null) {
            try {
                serverSocket.accept();
                try {
                    tomcat.stop();
                    tomcat.destroy();
                    System.setProperty(TOMCAT_KILL_SWITCH_ACTIVE, "false");
                    System.exit(0);
                }
                catch (LifecycleException e) {
                    System.err.println("Error stopping Tomcat: " + e.getMessage());
                    System.exit(1);
                }
            }
            catch (IOException e) {
                // just exit
            }
        }
    }

    protected static ServerSocket createKillSwitch(int killListenerPort) {
        try {
            return new ServerSocket(killListenerPort);
        }
        catch (IOException e) {
            return null;
        }
    }
}
