package testconsig1

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import java.util.UUID;

@Transactional(readOnly = true)
class Fileup1Controller {

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
	    
	    
	    
	    def cpara= new Consigparameters(filepath:filepath,jindex:params.jindex,minCon:params.minCon,maxCon:params.maxCon,uuid:uuid)
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
