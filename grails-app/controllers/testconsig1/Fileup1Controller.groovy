package testconsig1

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import java.util.UUID;



import jxl.Workbook
import jxl.write.Label
import jxl.write.WritableSheet
import jxl.write.WritableWorkbook




@Transactional(readOnly = true)
class Fileup1Controller {
     
    def exportService
    private static final String CONSIG_RESULT = "/usr/share/ConSig/StoreFile/"
    
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Fileup1.list(params), model:[fileup1Count: Fileup1.count()]
    }

    def show(Fileup1 fileup1) {
        respond fileup1
    }

    def create() {
        respond new Fileup1(params)
    }



     def consigMain()
    {
    println("inside main")
    File folder = new File("/usr/share/ConSig/GeneList/");
		File[] listOfFiles = folder.listFiles().sort();
		def listOfFilesNames =[]
		
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		        //System.out.println(file.getName());
		        listOfFilesNames.add(file.getName());
		    }
		}
		
		//println(listOfFiles)
		[listOfFiles:listOfFilesNames]
		
		
    }
    
     def tutorial()
    {
    println("inside tutorial")
    }
     def overview()
    {
    println("inside overview")
    }
     def citations()
    {
    println("inside citations")
    }
     def downloads()
    {
    println("inside downlaods")
    }
     def faq()
    {
    println("inside faq")
    }
     def news()
    {
    println("inside news")
    }
    
    def contacts()
    {
    println("inside contacts")
    }
    

    
    def OutputFile
    def result()
	    {
	    println( "froms result and params are $params")
	    println(params)
	    
	    def uuid=params.uuid
	    
	    //check status in db
	    def rjobs= Consigparameters.executeQuery("select status from Consigparameters where uuid=?",[uuid]) 
	    
	    println(uuid)
	    def firstrecord=rjobs[0]
	    def status=rjobs[0]	    
        println "status is ${status} "
        def outputfile
        if (status.equals("done"))
        {
           		String filOutputFile ="/usr/share/ConSig/StoreFile"+uuid + "_" + 'filOutputFile.txt';
		        String outputFile = "/usr/share/ConSig/StoreFile"+uuid + "_" + 'consig_output.txt';
		        def tokens =[]
		        ArrayList<OutputFile> d = new ArrayList<OutputFile>();
		        
				  try {
				        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(outputFile)));   
				        String line;
				        while ((line = br.readLine()) != null) {
				        
				           tokens = line.split("\t")				 		  
		        		   d.add(new OutputFile(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6],tokens[7],tokens[8],tokens[9],tokens[10]));
				        }
				        br.close();
				
				    } catch (IOException e) {
				        e.printStackTrace();
				    }


		        
			    
			    		
		
				if(params?.f && params.f != "html"){
	    		        response.setHeader("Content-disposition", "attachment; filename=test.${params.extension}")	
						response.contentType = grailsApplication.config.grails.mime.types[params.f]												
						exportService.export(params.f, response.outputStream,d, [:], [:])
						response.outputStream.flush()
				}
			    
			    	println("d sizze is $d.size()")
			    	[d:d]
			 
	    
	    }
	    else
	    {
	    
	    	redirect(action: "status", params: [status: status])
	    
	    }
	    }
     def status()
     {
      println("params from status $params")
      def status=params.status
      [status:status]
     }
     
     
     @Transactional
     def inpPara()
    {
    //roms inpPara and params are [geneList:672 675 1956, isGeneId:geneId, group1:example, genelistexamples:CGC_merged_BLA.txt, 
    //dbtype:precompile, slist:GO, minCon:5, maxCon:1500, email:inspiresnehal@gmail.com, submit:submit, 
    //databasefile:org.springframework.web.multipart.support.StandardMultipartHttpServletRequest$StandardMultipartFile@48754e47, 
    //action:inpPara, format:null, controller:fileup1]
    
        println( "froms inpPara and params are $params")	   
        println("and selection is $params.genelisttype ") 
	    String filepath
	    UUID uuid = UUID.randomUUID();	    
	    println("uuid created $uuid and jindex is $params.jindex")	   
	    
	    def userselection = params.group1
	    if(userselection.equals('user'))
	    {
				    def iformat= params.iformat	    
					    if(iformat.equals("upf"))
					    {
						     def f = request.getFile('myfile')
						     println("from the upload controller")
						     def filename = f.getOriginalFilename()
						     filepath='/usr/share/ConSig/StoreFile/'+filename
						     f.transferTo(new File(filepath))
						     println(filepath)
						     	 if (f.empty) {
										        flash.message = 'file cannot be empty'
										        render(view: 'uploadForm')
										        return
											    }	
					    }
					    else
					    {
						     def genelist = params.geneList
						     println(genelist.split('\\W+').size())
						     def lstSize = genelist.split('\\W+').size()
						     println(genelist.split('\\W+'))
						     def geneList = genelist.split('\\W+')
						     filepath='/usr/share/ConSig/StoreFile/'+uuid+'.txt'
						     File file = new File(filepath)
						     geneList.each {
						       String line = "Curate"+"\t"+"AllCancerGene"+"\t"+"${it}\n"
						       file << (line)
						    	 }
					     }
		     }
		     else
		     {
		     			def egfile = params.genelistexamples
		     			filepath= '/usr/share/ConSig/GeneList/'+egfile
		     
		     }
		    
		     
		    
		      //make file here
		      
		      
		    
		    
	    
	    	def status="queued"
	    	def userDbselection = params.dbtype
	    	def db =[]
	    	def databaselist
			def databasefile ="test.txt"
			
				    
	        if(userDbselection.equals('precompile'))
	        {
	    
				 
				    
				     
				     
				     
				    if(params.slist instanceof java.lang.String)
					{
						println("Statement is only one string")
						db.add(params.slist);
					}
					else
					{
						db = params.slist
					}
			}
			else
			{
					println("its in the custom database list")
				    db.add(params.slist);					    
				    def fdb = request.getFile('databasefile')
				    
					databasefile = fdb.getOriginalFilename()
					filepath='/usr/share/ConSig/GeneList/StoreFile/'+databasefile
					fdb.transferTo(new File(databasefile))
					if (f.empty) {
				        flash.message = 'file cannot be empty'
				        render(view: 'uploadForm')
				        return
					}	
				    
				    dbflag="custom"
					 
			    }
	     		databaselist=databasefile
			    println( "froms inpPara and databaselist are $databaselist")
			    println( "froms inpPara and db is  are $db")
			     
			    println( "froms inpPara and dbflag are $params.maxCon")
			      
			    println( "froms inpPara and conceptlis are $params.conceptList")
			    def dmaxcon = 1500
			    dmaxcon=params.maxCon
			    
			    def cpara= new Consigparameters(filepath:filepath,isgeneid:params.isGeneId,jindex:1,mincon:params.minCon,maxcon:dmaxcon,uuid:uuid,status:status,databaselist:databaselist)
			    cpara.save(insert:true)
			    
			        if (!cpara.save()) {
			    cpara.errors.each {
					        println it
					    }
			}
	    
     [uuid:uuid]
     
      
    }
    
    def genelist()
    {
     	

		File folder = new File("/usr/share/ConSig/GeneList/");
		File[] listOfFiles = folder.listFiles();
		
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		        //System.out.println(file.getName());
		    }
		}
		
		//println(listOfFiles)
		[listOfFiles:listOfFiles]

    
     
     
    
    }
   
   
    def downloadFile()
    {
    		println(params)
    		def file = new File(params.item)

			if (file.exists()) {
			   response.setContentType("text/plain")
			   response.setHeader("Content-disposition", "filename=${file.name}")
			   response.outputStream << file.bytes
			   return
			}
    
    
    }


    @Transactional
    def save(Fileup1 fileup1) {
        if (fileup1 == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (fileup1.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond fileup1.errors, view:'create'
            return
        }

        fileup1.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'fileup1.label', default: 'Fileup1'), fileup1.id])
                redirect fileup1
            }
            '*' { respond fileup1, [status: CREATED] }
        }
    }

    def edit(Fileup1 fileup1) {
        respond fileup1
    }
    
    @Transactional
    def upload() {
    
        println( "froms upload and params are $params")
	    def f = request.getFile('myfile')
	    println("from the upload controller")
	    def filename = f.getOriginalFilename()
	    
	    if (f.empty) {
        flash.message = 'file cannot be empty'
        render(view: 'uploadForm')
        return
	    }	    
	    String filepath='/home/snehal/ConSig/StoreFile/'+filename
	
	    f.transferTo(new File(filepath))
	    println(filepath)
	    UUID uuid = UUID.randomUUID();
	    
	    println("uuid created $uuid and jindex is $params.jindex")
	    
	    def status="queued"
	    
	    
	    
	    def cpara= new Consigparameters(filepath:filepath,jindex:params.jindex,minCon:params.minCon,maxCon:params.maxCon,uuid:uuid,status:status)
	    cpara.save(insert:true)
	    
	    if (!cpara.save()) {
	    cpara.errors.each {
			        println it
			    }
			}
	    
	    
	    
	    
	    
	    [filepath:filepath]
	}

    @Transactional
    def update(Fileup1 fileup1) {
        if (fileup1 == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (fileup1.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond fileup1.errors, view:'edit'
            return
        }

        fileup1.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'fileup1.label', default: 'Fileup1'), fileup1.id])
                redirect fileup1
            }
            '*'{ respond fileup1, [status: OK] }
        }
    }

    @Transactional
    def delete(Fileup1 fileup1) {

        if (fileup1 == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        fileup1.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'fileup1.label', default: 'Fileup1'), fileup1.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'fileup1.label', default: 'Fileup1'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
