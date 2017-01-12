<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'fileup1.label', default: 'Fileup1')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>     
        <g:external dir="css" file="style1.css" />
         <script type="text/javascript">
           function UploadGlFile(source)
    		{
    			var radioButtons = document.getElementsByName("iformat");
			    console.log(radioButtons.value);
			    for (var x = 0; x < radioButtons.length; x ++) {
			      if (radioButtons[x].checked) {
			      	console.log(radioButtons[x].value);
			           if(radioButtons[x].value == "gnl")
			          	 {
			          	 
			          	 var list = 
			   				'<ul class= "b">'
			   				+'<li><input type="radio" name="iformat" class="formObject" value="upf" onClick="UploadGlFile(this)"/ checked="checked" /><span class="formText">Upload File</span>'		   				
			   				+'<input type="radio" name="iformat" class="formObject" value="gnl" checked="checked" onClick="UploadGlFile(this)"/ /><span class="formText">Gene List</span></li>'			   							   					
			   				+'</ul>'
			   				+'<textarea name="geneList" id="geneList" cols="15" rows="15">672 675 1956</textarea></p>'     	
							
			          	 document.getElementById("inpFor").innerHTML = list;
			          	 
			          	 }
			          	 else if(radioButtons[x].value == "upf")
			          	 {
			          	 
			          	 var list = 
			   				
			   				'<ul class= "b">'
			   				+'<li><input type="radio" name="iformat" class="formObject" value="upf" checked="checked" onClick="UploadGlFile(this)"/ checked="checked" /><span class="formText">Upload File</span>'
			   				+'<input type="radio" name="iformat" class="formObject" value="gnl" onClick="UploadGlFile(this)"/ /><span class="formText">Gene List</span></li>'		
			   				+'<input id="uploadfile" type="file" name="myfile" size="30" class="formObject" > <br />'	   				
			   						   							   					
			   				+'</ul>' 
			   				
			   				
							
			          	 document.getElementById("inpFor").innerHTML = list;
			          	 
			          	 }
			      }
			      
			    }
    		}
    		
    		
    		function customDb(source)
    		{
    			
    				var db = document.getElementsByName("slist");
    				var flag=0
    				
    				for (var i=0, len=db.length; i<len; i++) {	
    						if(db[i].value=="custom" && db[i].checked)
    						{
    						flag=1
    						}
    						else
    						{
    						flag=0
    						}		
						    
						}
						
						
						if (flag == 1)
						{
					
    							    var list= 				
						            '<ul class="b">'	
									+'<li><label><input name="slist" value="interactome" type="checkbox"/><a href="">Interactome</a>'
									+'</label>'
									+'</li>'
									+'<li><label><input name="slist" value="protein_domains" type="checkbox"/><a href="">Protein Domains</a>'
									+'</label>'
									+'</li>'
									+'<li>'
									+'<label><input name="slist" value="GO" type="checkbox" id="go" /><a href="http://www.geneontology.org/">GO</a>'
									+'</label></li>'
									+'<li>'
									+'<label><input name="slist" value="pathways" type="checkbox" id="go" /><a href="">Pathways</a>'
									+'</label></li>'
									+'<li>'
									+'<label><input name="slist" value="custom" checked="checked" type="checkbox" id="go" onclick="customDb(this)"/><a href="">Custom</a>'
									+'</label></li>'
						   			+'</ul>'									
									+'<span class="formText" class="property-label">Upload my own concept database</span>'     
									+'<input type="file" name="databasefile" size="30" class="formObject"/>'
						
						
    							     document.getElementById("databaseList").innerHTML = list;
    					}
    					else
    					{
    					
    					  var list= 				
						            '<ul class="b">'	
									+'<li><label><input name="slist" value="interactome" type="checkbox"/><a href="">Interactome</a>'
									+'</label>'
									+'</li>'
									+'<li><label><input name="slist" value="protein_domains" type="checkbox"/><a href="">Protein Domains</a>'
									+'</label>'
									+'</li>'
									+'<li>'
									+'<label><input name="slist" value="GO" type="checkbox" id="go" /><a href="http://www.geneontology.org/">GO</a>'
									+'</label></li>'
									+'<li>'
									+'<label><input name="slist" value="pathways" type="checkbox" id="go" /><a href="">Pathways</a>'
									+'</label></li>'
									+'<li>'
									+'<label><input name="slist" value="custom" type="checkbox" id="go" onclick="customDb(this)"/><a href="">Custom</a>'
									+'</label></li>'
						   			+'</ul>'									
									
						
						
    							     document.getElementById("databaseList").innerHTML = list;
    					
    					
    					}		     
						
						
    		
    		
    		}
    
    
         
         
         
         </script>
    </head>
    <body>
    	
		
		<div id="textPanel">
		 
		 <div class="nav" role="navigation">
			<ul>
			 <li><a class="intro"  href="${createLink(uri:'/fileup1/consigMain')}">Web Service</a></li>
			 <li><a class="intro"  href="${createLink(uri:'/fileup1/tutorial')}">Tutorial</a></li>			 
			 <li><a class="intro"  href="${createLink(uri:'/fileup1/citations')}">Citations</a></li>
			 <li><a class="intro"  href="${createLink(uri:'/fileup1/overview')}>Overview</a></li>
			  <li><a class="intro"  href="${createLink(uri:'/fileup1/faq')}" download>FAQ</a></li>
			  <li><a class="intro"  href="${createLink(uri:'/fileup1/news')}">News</a></li>
			 <li><a class="intro"  href="mailto: conceptmetab-help@umich.edu">Contacts</a></li>
			 
			 	
			</ul>
		</div> 
		
		<center>
		<div id="formPanel">	
		<g:uploadForm controller="fileup1" action="inpPara" name="myUpload">
		<table id="basic">
				<tr>
				     <td align="right" valign="top"><span class="formText"><b>Input Format</b></span></td>
				<td>
				<div id="inpFor">
				
				  <input type="radio" name="iformat" class="formObject" value="upf" onClick="UploadGlFile(this)"/ checked="checked" /><span class="formText">Upload File</span>
				   <input type="radio" name="iformat" class="formObject" value="gnl" onClick="UploadGlFile(this)"/ /><span class="formText">Gene List</span>
				      <input id="uploadfile" type="file" name="myfile" size="30" class="formObject" > <br />
				   
				  	 
		  		
		  	   </div>	  
				</td>
				</tr>
				<tr>
				
				<td align="right" valign="top"><span class="formText"><b>Concept database</b></span>
				</td>
				<td>
					<div id="databaseList" style="margin-left:18px;">					
						<ul class="b">	
									<li><label><input name="slist" value="interactome" type="checkbox"/><a href="">Interactome</a>
									</label>
									</li>
									<li><label><input name="slist" value="protein_domains" type="checkbox"/><a href="">Protein Domains</a>
									</label>
									</li>
									<li>
									<label><input name="slist" value="GO" type="checkbox" id="go" /><a href="http://www.geneontology.org/">GO</a>
									</label></li>
									<li>
									<label><input name="slist" value="pathways" type="checkbox" id="go" /><a href="">Pathways</a>
									</label></li>
									<li><label><input name="slist" value="custom" type="checkbox" id="go" onclick="customDb(this)"/><a href="">Custom</a>
									</label></li>
						</ul>
						</div>
						</td>
						</tr>
					<tr>
					<td align="right" valign="top"><span class="formText"><b>Concept List</b></span></td>
					<td>	
					     
				    <textarea name="conceptList" cols="2" rows="1">test1 test2 test3</textarea></p>
				    </td>
				    </tr>
				    
				    <tr>
					<td align="right" valign="top"><span class="formText"><b>Ji Index</b></span></td>
					<td>					 
				      <input type="number" name="jindex" required="" value="1" id="jindex" />     
				    </td>
				    </tr>
				    
				    <tr>
					<td align="right" valign="top"><span class="formText"><b>Min Concepts</b></span></td>
					<td>					
				      <input type="number" name="minCon" required="" value="5" id="minCon" />
				    </td>
				    </tr>
				    
				     <tr>
					<td align="right" valign="top"><span class="formText"><b>Max Concepts</b></span></td>
					<td>					
				      <input type="number" name="maxCon" required="" value="1500" id="minCon" />
				    </td>
				    </tr>
				    </table>
				    
				    
				    </br>
			   </br>
				   <center> <g:submitButton name="submit" " value="submit" style="color: #0F226E;padding: 10px 32px; font-family: Georgia, ..., serif;border-radius: 8px;box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19); font-size: 15px;;font-style:bold;"/></centre>
				   
				   
	 
      				
      				
           </br>
			   </br>
          
       </g:uploadForm>
            
            </div>
            </div>
        </div>
    </body>
</html>

