<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'fileup1.label', default: 'Fileup1')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
       file is saved at "${filepath}"
    </body>
</html>
