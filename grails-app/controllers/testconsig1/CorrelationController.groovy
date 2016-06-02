package testconsig1

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CorrelationController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Correlation.list(params), model:[correlationCount: Correlation.count()]
    }

    def show(Correlation correlation) {
        respond correlation
    }

    def create() {
        respond new Correlation(params)
    }

    @Transactional
    def save(Correlation correlation) {
        if (correlation == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (correlation.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond correlation.errors, view:'create'
            return
        }

        correlation.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'correlation.label', default: 'Correlation'), correlation.id])
                redirect correlation
            }
            '*' { respond correlation, [status: CREATED] }
        }
    }

    def edit(Correlation correlation) {
        respond correlation
    }

    @Transactional
    def update(Correlation correlation) {
        if (correlation == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (correlation.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond correlation.errors, view:'edit'
            return
        }

        correlation.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'correlation.label', default: 'Correlation'), correlation.id])
                redirect correlation
            }
            '*'{ respond correlation, [status: OK] }
        }
    }

    @Transactional
    def delete(Correlation correlation) {

        if (correlation == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        correlation.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'correlation.label', default: 'Correlation'), correlation.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'correlation.label', default: 'Correlation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
