Asaas Grails Tomcat 7 Plugin
======================

Este Plugin faz o Tomcat 7 o container padrão para rodar o Grails.

Construindo o Plugin
======================
Com o grails 2.5.6 em modo interativo, siga os passos:
```shell
grails> compile
grails> package-plugin
grails> generate-pom
```

* Copie para uma pasta reservada e renomeie o arquivo na pasta raiz do projeto de `grails-tomcat-7.0.94.zip` para `tomcat-7.0.94.zip`.
* Copie para uma pasta reservada e renomeie o arquivo em `target\pom.xml` para `tomcat-7.0.94.pom`.
* Gere o sha1 dos dois arquivos com um gerador online ou offline e crie os respectivos arquivos `tomcat-7.0.94.zip.sha1` e `tomcat-7.0.94.pom.sha1` na pasta reservada.

* No final do processo a pasta deve estar assim:
```
tomcat-7.0.94.pom
tomcat-7.0.94.pom.sha1
tomcat-7.0.94.zip
tomcat-7.0.94.zip.sha1
```

* Faça o Upload dos arquivos para o repositório do maven/s3.
* Modifique o arquivo `BuildConfig.groovy` para a versão deployada.
* Teste o download das dependências e as alterações.

