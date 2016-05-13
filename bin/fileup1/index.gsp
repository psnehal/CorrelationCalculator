<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'fileup1.label', default: 'Fileup1')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-fileup1" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div> 
        
        <div id="list-fileup1" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:form action="upload" enctype="multipart/form-data" useToken="true">
            <span class="button">                   
                    <input type="file" name="myfile"/>
                    <g:field type="number" name="jindex" required="" value="1"/>
                    <g:field type="number" name="minCon" required="" value="5"/>
                    <g:field type="number" name="maxCon" value="1500"/>
                    <input type="submit" class="upload" value="upload"/>
            </span>
             
             
            </g:form>
        
            <f:table collection="${fileup1List}" />
            <div class="pagination">
                <g:paginate total="${fileup1Count ?: 0}" />
            </div>
        </div>
    </body>
</html>
