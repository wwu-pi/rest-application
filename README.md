# Example demo for REST in Spring
The repository contains two subprojects: `rest` and `rest-client`. 
`rest` contains a running REST application with Spring's `@RestController`, a service, and some manually written DTOs. Running the main method will start the application.
`rest-client` contains the same manually written DTOs and a REST client written as a `@Component`. Running the main method will execute some exemplary requests against the running application. Note that in an application the `AdderRestClient` should be used via `@Autowired`.