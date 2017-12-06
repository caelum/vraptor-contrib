## vraptor-j2html

Uma engine simples para renderização de html usando a biblioteca J2Html, a qual usa classe e métodos para geração de elementos
e atributos html.

A engine não obriga a utilização do J2Html, visto que as convenções do VRaptor continuam habilitadas.
Ela só é requisitada nos métodos ou classes que possuem a anotação @J2HtmlRenderer, ou seja, 
é possível usar a mesma classe de renderização da view para todos os métodos de um controller, ou, especificamente para um método.

A biblioteca já possui classe default de renderização dos elementos containers padrão de um documento html como html, head e body.
Possui também uma renderização de página de erro padrão

Todos as classes default podem ser sobrescritas usando as especificações da Api de CDI do Java


# instalando

VRaptor-J2Html.jar pode ser adicionado a um projeto VRaptor usando maven:

```
		<dependency>
			<groupId>br.com.neo</groupId>
			<artifactId>vraptor-j2html</artifactId>
			<version>0.0.6</version>
			<scope>compile</scope>
		</dependency>
```

# renderizacao das views

```
		public class Client {
			
			private String login;
			
			public String getLogin() {
				return login;
			}
			
			public void setLogin(String login) {
				this.login = login;
			}
		}
		
		@Controller
		public class HomeController {								
			
			@Path({"/", ""})
			@J2HtmlRenderer(HomeRenderer.class)
			public Client home() {
				Client client = new Client();
				client.setLogin("admin");
				return client;
			}
			
		}
		
		public class HomeRenderer implements ViewRenderer {
	
			private ViewAttributesWrapper attributes;
			
			public HomeRenderer(ViewAttributesWrapper attributes) {
				this.attributes = attributes;
			}
		
			@Override
			public DomContent[] getElements() throws ViewJ2HtmlException {
				Client client = attributes.getRequestAttribute("client", Client.class);
				return new DomContent[] {text(client.getLogin()), br()};
			}
		
		}
		
		
		<!-- html final -->
		<!DOCTYPE html>
		<html>
			<head>
			</head>
			<body>
				admin
			</body>
		</html>
```

# sobrescrevendo os containers padrão

```
		@Specializes
		@RequestScoped
		public class CustomBody extends DefaultBodyRenderer {
		
			@Override
			public ContainerTag getContainer(DomContent... content) throws ViewJ2HtmlException {
				List<DomContent> contents = Lists.newArrayList(content);
				contents.add(0, h1("Titulo"));
				return body(contents.toArray(new DomContent[0]));
			}
		
			@Override
			public ContainerTag getContainer(String content) throws ViewJ2HtmlException {		
				content = "<h1>Titulo</h1>" + content;
				return body(content);
			}
		
		}
		
		<!-- html final -->
		<!DOCTYPE html>
		<html>
			<head>
			</head>
			<body>
				<h1>Titulo</h1>
				admin
			</body>
		</html>
```

# ajuda

Site do J2Html com muitos exemplos de utilização:

https://j2html.com/