<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'fileup1.label', default: 'Fileup1')}" />
        <title>Consig Input</title>     
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
			          	 	'<input type="radio" name="iformat" class="formObject" value="gnl" checked="checked" onClick="UploadGlFile(this)" /><span class="formText">Gene List</span>'		
			   				+'<input type="radio" name="iformat" class="formObject" value="upf" onClick="UploadGlFile(this)"  /><span class="formText">Upload File</span> <br />'  
			   				+'<textarea name="geneList" id="geneList" cols="15" rows="15">672 675 1956</textarea></p>' 
			   				+'<input name="isGeneId" class="formObject" value="geneId" checked="checked" type="radio"><span class="formText">Entrez Gene Id</span> <input name="isGeneId" class="formObject" value="geneSymbol" type="radio"><span class="formText">Official Gene Symbol</span>'    	
							
			          	 document.getElementById("inpFor").innerHTML = list;
			          	 
			          	 }
			          	 else if(radioButtons[x].value == "upf")
			          	 {
			          	 
			          	 var list = 
			          	    	
			   				'<input type="radio" name="iformat" class="formObject" value="gnl" onClick="UploadGlFile(this)"/ /><span class="formText">Gene List</span></li>'
			   				+'<input type="radio" name="iformat" class="formObject" value="upf" checked="checked" onClick="UploadGlFile(this)"/ checked="checked" /><span class="formText">Upload File</span>'			   				
			   				+'<input id="uploadfile" type="file" name="myfile" size="30" class="formObject" > <br />'	
			   				+'<input name="isGeneId" class="formObject" value="geneId" checked="checked" type="radio"><span class="formText">Entrez Gene Id</span> <input name="isGeneId" class="formObject" value="geneSymbol" type="radio"><span class="formText">Official Gene Symbol</span>'			
			   								
			          	 document.getElementById("inpFor").innerHTML = list;
			          	 
			          	 }
			          	 else if(radioButtons[x].value == "ugnl")
			          	 {
			          	 alert("inside ugnl");
			          	   var list = 
			          	  
			          	    '<input type="radio" name="iformat" class="formObject" value="gnl" onClick="UploadGlFile(this)" /><span class="formText">Gene List</span>'
						    +'<input type="radio" name="iformat" class="formObject" value="upf" onClick="UploadGlFile(this)" /><span class="formText">Upload File</span>'
						    +'<input type="radio" name="iformat" class="formObject" value="ugnl" onClick="UploadGlFile(this)" checked="checked"  /><span class="formText">Example Gene List</span><br/>'						   
						    +'<br/>'
						    	 +'<input name="isGeneId" class="formObject" value="geneId" checked="checked" type="radio"><span class="formText">Entrez Gene Id</span> <input name="isGeneId" class="formObject" value="geneSymbol" type="radio"><span class="formText">Official Gene Symbol</span>'
						    	
						    	  
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
    
    
    
            function expandAdvancedOptions()
			{
				
				
		 document.getElementById("more").innerHTML = 
				'The applications of uniConSig can also extend to fields other than cancer. Based on the prioritization results'
			   +'from uniConSig scores, we are able to quantify the functional associations between two diseases or one disease Vs. one pathway, providing a '
			   +'more rational quantification than Fisher’s Exact test (which is used broadly for gene set enrichment analysis).<br/>'
			   +'To our knowledge, UniConSig is the first tool for genome-wide quantification of gene functions and disease associations. UniConSig has broad'
			   +'applications for gene prioritization for genomic-based studies to discover new disease causal genes or new gene functions.'
			   +' To perform UniConSig analysis, please provide the following datasets:<br/>'
               +'(1) Training Gene list (i.e. the list of Known Cancer Genes)<br/>'
               +'(2) Gene Concept Database (i.e. Pathways, Gene Ontologies, Molecular Interactions, Domains)</span>'
			   +'<a href = "#" onclick="closeExp()">less</a>';
				
			}
			
			function closeExp()
			{
				document.getElementById("more").innerHTML = '<a href = "#" onclick="expandAdvancedOptions()">more</a>';
			}
    
         
         
         
         </script>
    </head>
    <body>
    	
		
		<div id="textPanel">
		 
		 <div class="nav" role="navigation">
			<ul>
			 <li><a class="intro"  href="${createLink(uri:'/fileup1/consigMain')}">Web Service</a></li>
			 <li><a class="intro"  href="${createLink(uri:'/fileup1/tutorial')}">How It works!!!</a></li>			 
			 <li><a class="intro"  href="${createLink(uri:'/fileup1/citations')}">Citations</a></li>			
			<!--  <li><a class="intro"  href="${createLink(uri:'/fileup1/faq')}" download>FAQ</a></li>-->
			<!--  <li><a class="intro"  href="${createLink(uri:'/fileup1/news')}">News</a></li> -->
			   <li><a class="intro"  href="${createLink(uri:'/fileup1/genelist')}">Gene List Collection </a></li>
			 <li><a class="intro"  href="mailto: conceptmetab-help@umich.edu">Contacts</a></li>
			 
			 	
			</ul>
		</div> 
		
		<center>
		<div id="formPanel">	
		
		<div id="contentPanel2">
		<h2> Overview</h2>
		One of the greatest hurdles for cancer biologists is to identify the cancer-causal genes from thousands of candidate genes suggested by 
		large-scale genomics or deep sequencing studies. In our previous study, we discovered that cancer genes possess a complicated yet distinct “gene concept signature.” 
		Concept Signatures include cancer-related signaling pathways, molecular interactions, transcriptional motifs, protein domains, and gene ontologies. We developed a Concept
		 Signature (or ConSig) analysis that prioritizes the biological importance of candidate genes underlying cancer by computing their strength of association with those 
		 cancer-related signature concepts. The ConSig analysis has facilitated the discovery of a recurrent ESR1-CCDC170 gene fusion in more aggressive Luminal B breast cancers 
		 (Nat. Commun. 2014) as well as TLK2, MAP3K3, and MYST3 amplifications in aggressive luminal breast cancer (Nat. Commun. 2016, J. Pathol. 2014, Oncogene In press). 
		 Nevertheless, current candidate gene prioritization methods, including ConSig, are subject to bias from redundancy in the compiled knowledgebase (also known as gene 
		 concept database). This leads to variation of the gene ranking and jeopardizes the reliability of the analysis.  
			<br/>
		In light of these problems, we developed an innovative, universal algorithm called uniConSig. By penalizing overlapping concepts with a stable parameter, 
		“effective concept number”, we avoid the fluctuation in uniConSig scores, and stabilize the ranking of the genes even with the randomly duplicated gene 
		concept databases. We tested the uniConSig algorithm by identifying known cancer genes based on a cancer gene list, and found that the uniConSig algorithm
		 demonstrated significantly enhanced prioritization of known cancer genes compared to the ConSig algorithm, and the results are stable even in the presence
		  of randomly duplicated gene concept databases. In addition, we used calculations based on the dominant/recessive cancer gene lists, and were able to provide
		   a quantitative measure of the potential dominant/recessive functions of human genes underlying cancer. As an example application of this algorithm, we show 
		   that the uniConSig scores can directly reveal the primary oncogene targets from genomic amplicons in breast cancer.  
		   <br/>


           <div id="more">
				<a href = "#" onclick="expandAdvancedOptions()">more</a>
			</div>
		
			
			
			
		</div>
		
		<g:uploadForm controller="fileup1" action="inpPara" name="myUpload">
		<hr/>
		<table cellspacing="0" id="basic">
		        <tr>
		        <td colspan="2"><span class="formText2">
		        <h3> Input Parameters </h3>
                </td>
                </tr>
		
				<tr>
				<td align="right" valign="top">
					<span class="formText"><b>Training Gene List: </b></span>
				</td>
				<td>
					<input type="radio" name="group1"  value="user"><span class="formText2"><b>User gene list</b></span></br>		
					<div id="inpFor">							   
					   <input type="radio" name="iformat" class="formObject" value="gnl" onClick="UploadGlFile(this)"  /><span class="formText2">Gene List</span>
					   <input type="radio" name="iformat" class="formObject" value="upf" onClick="UploadGlFile(this)"//><span class="formText2">Upload File</span>
					   <br/>
					   <textarea name="geneList" id="geneList" cols="15" rows="15">672 675 1956</textarea></br>
					   <input name="isGeneId" class="formObject" value="geneId" checked="checked" type="radio"><span class="formText2">Entrez Gene Id</span> 
					   <input name="isGeneId" class="formObject" value="geneSymbol" type="radio"><span class="formText2">Official Gene Symbol</span>					  
					</div>  
					
				    <input type="radio" name="group1" value="example"><span class="formText2"><b>Example gene list</b></span></br>
				    <div id="inpFor">		
				 	<g:select name="genelistexamples" from="${listOfFiles}" />
				 	</div>
				 	<span class="footnote">Training gene list: a list of genes which are known to be associated with a certain disease or phenotype (such as cancer, or more specifically, leukemia). Note: only Human genes are accepted currently.
				 	An example is provided here.</span>
				 </td>						
				</tr>	
						
				<tr>				
				<td align="right" valign="top">
				<span class="formText"><b>Gene Concept Database: </b></span>
				</td>
				<td>
					
						<input type="radio" name="dbtype" value="precompile"><span class="formText2"><b>Precompiled Concepts</b></span></br>					
						<div id="inpFor">
						   <ul class="b">	
									<li><label><input name="slist" value="interactome" type="checkbox"/><a href=""><span class="formText2">Interactome</span></a>
									</label>
									</li>
									<li><label><input name="slist" value="protein_domains" type="checkbox"/><a href=""><span class="formText2">Protein Domains</span></a>
									</label>
									</li>
									<li>
									<label><input name="slist" value="GO" type="checkbox" checked="checked" id="go" /><a href="http://www.geneontology.org/"><span class="formText2">Gene Ontology</span></a>
									</label></li>
									<li>
									<label><input name="slist" value="pathways" type="checkbox" id="go" /><a href=""><span class="formText2">Pathways(MSigDB, Pathway Commons)</a>
									</label></li>
						</ul>
						</div>
							
						<input type="radio" name="dbtype" value="custom"><span class="formText2"><b>Custom database</b></span></br>	
						<div id="inpFor">
							
							<span class="formText2" class="property-label">Upload my own concept database</span>     
							<input type="file" name="databasefile" size="30" class="formObject"/>
						
						</div>
						<span class="footnote"> a database composed of concepts, which are groups of genes annotated by a term (such as concept GO: 0097194 (execution phase of apoptosis) consists of 55 genes)</span>
						</td>
						</tr>
				
				    
				
				    
				    <tr>
					<td align="right" valign="top"><span class="formText"><b>Minimum concept size cutoff:  </b></span></td>
					<td>					
				      <input type="number" name="minCon" required="" value="5" id="minCon" />
				    </td>
				    </tr>
				    
				     <tr>
					<td align="right" valign="top"><span class="formText"><b>Maximum concept size cutoff: </b></span></td>
					<td>					
				      <input type="number" name="maxCon" required="" value="1500" id="minCon"/>
				    </td>
				    </tr>
				    
				    
				    <td align="right" valign="top"><span class="formText"><b>Email:</b></span>
										</td>
										<td><input id="email" type="text" name="email" size="30"
											class="formObject"> <br /><span
											class="footnote">Please provide your email address if
												you wish to be notified when the analysis has been
												completed.</span>
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

