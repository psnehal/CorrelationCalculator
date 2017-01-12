package testconsig1

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/" (controller:"fileup1", action:"consigMain")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
