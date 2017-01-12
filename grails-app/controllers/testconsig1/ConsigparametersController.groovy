package testconsig1


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ConsigparametersController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Consigparameters.list(params), model:[consigparametersCount: Consigparameters.count()]
    }

    def show(Consigparameters consigparameters) {
        respond consigparameters
    }
    
 

    def create() {
        respond new Consigparameters(params)
    }

    @Transactional
    def save(Consigparameters consigparameters) {
        if (consigparameters == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (consigparameters.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond consigparameters.errors, view:'create'
            return
        }

        consigparameters.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'consigparameters.label', default: 'Consigparameters'), consigparameters.id])
                redirect consigparameters
            }
            '*' { respond consigparameters, [status: CREATED] }
        }
    }

    def edit(Consigparameters consigparameters) {
        respond consigparameters
    }

    @Transactional
    def update(Consigparameters consigparameters) {
        if (consigparameters == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (consigparameters.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond consigparameters.errors, view:'edit'
            return
        }

        consigparameters.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'consigparameters.label', default: 'Consigparameters'), consigparameters.id])
                redirect consigparameters
            }
            '*'{ respond consigparameters, [status: OK] }
        }
    }

    @Transactional
    def delete(Consigparameters consigparameters) {

        if (consigparameters == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        consigparameters.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'consigparameters.label', default: 'Consigparameters'), consigparameters.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'consigparameters.label', default: 'Consigparameters'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
