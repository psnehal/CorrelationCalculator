<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <div id="masthead">
    <br/>
     
    <div id="masthead">
	<a href="${createLink(uri: '/')}"><img src="${resource(dir: 'images', file: 'UniConSig.gif')}" alt="ConSig" style="max-height: 500px; max-width: 500px;" /></a>
	</div>
	
    
	</div>
    <title>
        <g:layoutTitle default="ConSig"/>
    </title>
   
    <asset:stylesheet src="application.css"/>
    <g:layoutHead/>
</head>
<body>

    

    <g:layoutBody/>
    <div class="footer" role="contentinfo"></div>
    <div id="spinner" class="spinner" style="display:none;">
        <g:message code="spinner.alt" default="Loading&hellip;"/>
    </div>
    <asset:javascript src="application.js"/>

</body>
</html>
