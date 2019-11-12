Asaas Grails Tomcat 9 Plugin
======================

Este Plugin faz o Tomcat 9 o container padrão para rodar o Grails.

Construindo o Plugin
======================
Com o grails 2.5.6 em modo interativo, siga os passos:
```shell
grails> compile
grails> package-plugin
grails> generate-pom
```

* Copie para uma pasta reservada e renomeie o arquivo na pasta raiz do projeto de `grails-tomcat-9.0.x.zip` para `tomcat-9.0.x.zip`.
* Copie para uma pasta reservada e renomeie o arquivo em `target\pom.xml` para `tomcat-9.0.x.pom`.
* Gere o sha1 dos dois arquivos com um gerador online ou offline e crie os respectivos arquivos `tomcat-9.0.x.zip.sha1` e `tomcat-9.0.x.pom.sha1` na pasta reservada.

* No final do processo a pasta deve estar assim:
```
tomcat-9.0.x.pom
tomcat-9.0.x.pom.sha1
tomcat-9.0.x.zip
tomcat-9.0.x.zip.sha1
```

* Faça o Upload dos arquivos para o repositório do maven/s3.
* Modifique o arquivo `BuildConfig.groovy` para a versão deployada.
* Teste o download das dependências e as alterações.

