if (System.getenv('TRAVIS_BRANCH')) {
    grails.project.repos.grailsCentral.username = System.getenv('GRAILS_CENTRAL_USERNAME')
    grails.project.repos.grailsCentral.password = System.getenv('GRAILS_CENTRAL_PASSWORD')
}

grails.project.work.dir = 'target'

grails.project.dependency.resolver = 'maven'
grails.project.dependency.resolution = {

    inherits 'global'
    log 'warn'

    repositories {
        mavenLocal()
        grailsCentral()
        mavenCentral()
    }

    dependencies {
        String tomcatVersion = '9.0.97'
        String tomcatLogVersion = '8.5.2'

        compile "org.apache.tomcat.embed:tomcat-embed-core:$tomcatVersion"

        ['el', 'jasper', 'websocket'].each {
            runtime "org.apache.tomcat.embed:tomcat-embed-$it:$tomcatVersion"
        }

        ['logging-log4j', 'logging-juli'].each {
            runtime "org.apache.tomcat.embed:tomcat-embed-$it:$tomcatLogVersion"
        }
    }

    plugins {
        build ':release:3.1.2', ':rest-client-builder:2.1.1', {
            export = false
        }
    }
}
