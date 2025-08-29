Asaas Grails Tomcat 9 Plugin
======================

Este Plugin faz o Tomcat 9 o container padrão para rodar o Grails.

Atualizando a versão do Plugin
======================
* Modifique a versão do tomcat no arquivo `TomcatGrailsPlugin.groovy`, campo `version`.

```groovy
class TomcatGrailsPlugin {
    def version = '9.0.108'
    def grailsVersion = '2.5 > *'
// ...
}
```

* Modifique a versão do tomcat no arquivo `BuildConfig.groovy`, variável `tomcatVersion`.

```groovy
// ...
    dependencies {
        String tomcatVersion = '9.0.108'
        String tomcatLogVersion = '8.5.2'
// ...
```

Construindo o Plugin
======================
Com o grails 2.5.6 em modo interativo, siga os passos:
```shell
grails> compile
grails> package-plugin
grails> generate-pom
```

* Crie uma pasta reservada para os arquivos que serão criados;
* Copie o arquivo `grails-tomcat-9.0.x.zip` para a pasta criada;
* Renomeie o arquivo copiado de `grails-tomcat-9.0.x.zip` para `tomcat-9.0.x.zip`.
* Copie o arquivo `target\pom.xml` para a pasta criada;
* Renomeie o arquivo `pom.xml` para `tomcat-9.0.x.pom`.
* Gere o sha1 dos dois arquivos com um gerador online ou offline e crie os respectivos arquivos `tomcat-9.0.x.zip.sha1` e `tomcat-9.0.x.pom.sha1` na pasta reservada. No Linux os comandos seriam esses:

```
sha1sum tomcat-9.0.x.zip | cut -d " " -f 1 >> tomcat-9.0.x.zip.sha1
sha1sum tomcat-9.0.x.pom | cut -d " " -f 1 >> tomcat-9.0.x.pom.sha1
```

* No final do processo a pasta deve estar assim:
```
tomcat-9.0.x.pom
tomcat-9.0.x.pom.sha1
tomcat-9.0.x.zip
tomcat-9.0.x.zip.sha1
```

Testando o Plugin Localmente
======================

* Crie uma nova pasta em `~/.m2/repository/org/grails/plugins/tomcat/` para a versão que está sendo testada:
```shell
mkdir -p ~/.m2/repository/org/grails/plugins/tomcat/9.0.x
```
* Copie os 4 arquivos criados na etapa de build para essa pasta;
* Modifique o arquivo `BuildConfig.groovy` para a versão desejada;
* Faça o clean do projeto e também remova a pasta `target`, em seguida compile;
```shell
grails clean
rm -rf target

grails compile
```
* Execute a aplicação normalmente e verifiq;
* Lembre de remover a pasta criada após os testes.

Publicando o Plugin
======================

* Crie a pasta `releases/org/grails/plugins/tomcat/9.0.x` no bucket s3 `asaas-plugin-repository`;
* Faça o upload dos 4 arquivos para essa pasta;
* Teste o download das dependências e as alterações.

