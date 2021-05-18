<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<!-- Created By CodingNepal -->
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Carlos Laurine Personal Portfolio Website</title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" />
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/typed.js/2.0.11/typed.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/waypoints/4.0.1/jquery.waypoints.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />

</head>
<body>
	<div class="scroll-up-btn">
		<i class="fas fa-angle-up"></i>
	</div>
	<nav class="navbar">
		<div class="max-width">
			<div class="logo">
				<a href="#">Portfo<span>lio.</span></a>
			</div>
			<div class="menu" style="text-align: center; color:#FFF; color: crimson;font-size: 18px;font-weight: 500; line-height: 24px;background:rgb(229, 252, 252); padding:1.5em; border-radius: 1.5em; font-family: 'Poppins', sans-serif;"><%= (request.getAttribute("mailMsg")==null)?"":request.getAttribute("mailMsg") %></div>
			<ul class="menu">
				<li><a href="#home" class="menu-btn">Home</a></li>
				<li><a href="#about" class="menu-btn">About</a></li>
				<li><a href="#services" class="menu-btn">Services</a></li>
				<li><a href="#skills" class="menu-btn">Skills</a></li>
				<li><a href="#contact" class="menu-btn">Contact</a></li>
			</ul>
			<div class="menu-btn">
				<i class="fas fa-bars"></i>
			</div>
		</div>
	</nav>

	<!-- home section start -->
	<section class="home" id="home">
		<div class="max-width">
			<div class="row">
				<div class="home-content">
					<div class="text-1">Hi, I am</div>
					<div class="text-2">Carlos Laurine</div>
					<div class="text-3">
						And I'm a <span class="typing"></span>
					</div>
					<a href="#contact">Hire me</a>
				</div>
			</div>
		</div>
	</section>

	<!-- about section start -->
	<section class="about" id="about">
		<div class="max-width">
			<h2 class="title">About me</h2>
			<div class="about-content">
				<div class="column left">
					<img src="images/logo-ucsal.png" alt="Catholic University of Salvador Logo">
					<img src="images/java-logo.png" alt="Java Vintage Cup Logo">
				</div>
				<div class="column right">
					<div class="text">
						I'm Carlos and I'm a <span class="typing-2"></span>
					</div>
					<p>I am currently a Sophomore Student of Software Engineering at the Catholic University of Salvador (UCSAL). 
					   This specific Course is well-known for its heavily-focused Teaching Guidelines directed towards at Java Development. 
					   Most of my Subjects are taught in Java, and most of my Tests and Team Projects require it too! This has brought me a 
					   lot of experience and self-confidence on designing and building Back End/Full Stack applications during my Undergrad 
					   course up to now. </p>
					<p>In this sense, besides my Core Undergrad, I have been studying a lot of specific topics through Online Courses,
					   Events, Tutorials, Internships, Hackathons and Bootcamps, and much more. During my daily coding studies, I have enhanced 
					   and shaped meaningful and practical knowledge at subjects such as Web Development, Data Base Operations, API management,
					   Coding Standards and Best Practices, Agile Team Development, Business Modeling, et cetera.</p>
					<p>In parallel to this daily schedule, I have always been in contact with Innovative Environments and Initiatives.
					   Since Entrepreneurship and Innovation are some of my greatest passions, I and two other friends have idealized the "Scupp!",
					   a social networking concept for "Breaking the Ice" at First-Contact Conversations. Thanks to Scupp!, I have been imerged in a
					   daily basis at my now Natural Habitat - the Startup Environment. Either through Partners, Mentors, or Team Assignments and
					   Mentorship Programs, I realized once for all that Coding, Tech and Innovation are my main Passions. Imerged in them, I see
					   my hours flying, and easily spend my morning, evenings and nights coding without much effort. This is me, and this is what i love to do! </p>
				    
				    <p>That being said, all of these past and present backgrounds were more thoroughly depicted at my CV, with Demo 
				       Independent Projects and further Academic Information. </p>   
					<a href="https://carloslaurine.github.io/" target="_blank">Visit my Name Card</a>
					<a href="DemoContactsListFile.pdf" download="Carlos Laurine Dev (Resume/Portfolio)" target="_blank">Upload my Portfolio</a>
				</div>
			</div>
		</div>
	</section>

	<!-- services section start -->
	<section class="services" id="services">
		<div class="max-width">
			<h2 class="title">My services</h2>
			<div class="serv-content">
			
			 	<div class="card">
					<div class="box">
						<i class="fas fa-chart-line"></i>
						<div class="text">Web Development</div>
						<p>I have been developing independent Java Web Projects, with knowledge in HTTP Protocol, JS Validations and Webservices with Ajax. The respective Back End's Builds vary from Maven to Spring Boot Projects, and also encompass JDBC, JPA and Hibernate along with various Java APIs and Libraries</p>
					</div>
				</div>
				<div class="card">
					<div class="box">
						<i class="fas fa-paint-brush"></i>
						<div class="text">Web Layouts</div>
						<p>Even though my focus is on Back End, I am also developing some WebApps' respective Interfaces. In this sense, I mainly
						give HTML/CSS/JS maintenance at some independent pages, specially at my Tech Startup's (Scupp!) Landing Page. It's Link/Code Repo is available at my Resume for further Code/Layout display</p>

					</div>
				</div>
				<div class="card">
					<div class="box">
						<i class="fas fa-code"></i>
						<div class="text">Full Stack Notions</div>
						<p>I am currently enrolled in several Projects, Studies and a Bootcamp directed towards full Web Development with Spring Boot for the Back End Server-Side Layers, ReactJS and Bootstrap for the View Layer at MVC Architecture, and MySQL/PostgreSQL for the DataBase Persistence Management</p>
					</div>
				</div>
				<div class="card" style="margin-top:2.1em;">
					
				</div>
				
				<div class="card" style="margin-top:2.1em;">
					<div class="box">
						<i class="fas fa-chart-line"></i>
						<div class="text">Web Apps Hosting and Deployment</div>
						<p>In order to build my Online Portfolio, I have acquired some hands-on, meaningful experience on Deployment and Hosting of WebApps and their respective Databases (MySQL/PostgreSQL) with Heroku, Netlify and CPanel (through MochaHost).  </p>
					</div>
				</div>
				<div class="card" style="margin-top:2.1em;">
					
				</div>
				
			</div>	
		</div>
		
	</section>

	<!-- skills section start -->
	<section class="skills" id="skills">
		<div class="max-width">
			<h2 class="title">My skills</h2>
			<div class="skills-content">
				<div class="column left">
					<div class="text">My Creative Skills & Experiences.</div>
					<p>The following are some of the Technologies and Languages that I have been in contact with during my Studies and Independent Applications/Code Development path. If you prefer, you can see all of my hands-on practices in my Repositories at my GitHub Page. The great majority of the Codes and Apps there have intentional, deep detailed Development Comments along each section of the the respective Source Codes in order to display properly each one of the Dev Technologies, Languages and Tactics explored.</p>
					<a href="https://github.com/CarlosLaurine" target="_blank">Visit my GitHub Profile!</a>
				</div>
				<div class="column right">
					<div class="bars">
						<div class="info">
							<span>Java</span> <span>90%</span>
						</div>
						<div class="line html"></div>
					</div>
					<div class="bars">
						<div class="info">
							<span>JSP</span> <span>90%</span>
						</div>
						<div class="line html"></div>
					</div>
					<div class="bars">
						<div class="info">
							<span>Bootstrap</span> <span>50%</span>
						</div>
						<div class="line php"></div>
					</div>
					<div class="bars">
						<div class="info">
							<span>Maven</span> <span>90%</span>
						</div>
						<div class="line html"></div>
					</div>
					<div class="bars">
						<div class="info">
							<span>HTML</span> <span>90%</span>
						</div>
						<div class="line html"></div>
					</div>
					<div class="bars">
						<div class="info">
							<span>CSS</span> <span>60%</span>
						</div>
						<div class="line css"></div>
					</div>
						<div class="bars">
						<div class="info">
							<span>HTTP Protocol</span> <span>70%</span>
						</div>
						<div class="line mysql"></div>
					</div>
					<div class="bars">
					<div class="bars">
						<div class="info">
							<span>JavaScript</span> <span>50%</span>
						</div>
						<div class="line php"></div>
					</div>
					<div class="bars">
						<div class="info">
							<span>JSF</span> <span>90%</span>
						</div>
						<div class="line html"></div>
					</div>
					
					<div class="bars">
						<div class="info">
							<span>Spring Boot</span> <span>50%</span>
						</div>
						<div class="line php"></div>
					</div>
					<div class="bars">
						<div class="info">
							<span>MySQL</span> <span>70%</span>
						</div>
						<div class="line mysql"></div>
					</div>
					<div class="bars">
						<div class="info">
							<span>PostgreSQL</span> <span>70%</span>
						</div>
						<div class="line mysql"></div>
					</div>
				</div>
			</div>
		</div>
		</div>
	</section>

	<!-- contact section start -->
	<section class="contact" id="contact">
		<div class="max-width">
			<h2 class="title">Contact me</h2>
			<div class="contact-content">
				<div class="column left">
					<div class="text">Get in Touch</div>
					<p>Please feel free to contact me through my mailbox using the "Message Me" section right here, or to use my personal info below to reach out to me in the best way possible. You can also get a Custom Mail with some Additional Info Links from me by fulfilling the last section on the right with your Name and E-mail! It's as easy as that!</p>
					<div class="icons">
						<div class="row">
							<i class="fas fa-user"></i>
							<div class="info">
								<div class="head">Name</div>
								<div class="sub-title">Carlos Laurine</div>
							</div>
						</div>
						<div class="row">
							<i class="fas fa-map-marker-alt"></i>
							<div class="info">
								<div class="head">Address</div>
								<div class="sub-title">Salvador, Brazil</div>
							</div>
						</div>
						<div class="row">
							<i class="fas fa-user"></i>
							<div class="info">
								<div class="head">Phone</div>
								<div class="sub-title">+55 (71) 99318-7816</div>
							</div>
						</div>
						<div class="row">
							<i class="fas fa-envelope"></i>
							<div class="info">
								<div class="head">Email</div>
								<div class="sub-title">vitorlaurinepinho@gmail.com</div>
							</div>
						</div>
					</div>
				</div>
				<div class="column right" style="margin-top: -6em;">
					<div class="text">Message Me</div>
					<form class="contact-form" action="mailInfo?action=send"
						method="post">

						<div class="fields">
							<div class="field name">
								<input type="text" class="fullname" placeholder="Name"
									name="name" id="name">
							</div>
							<div class="field email">
								<input type="text" class="email-input" placeholder="Email"
									name="email" id="email">
							</div>
						</div>
						<div class="field">
							<input type="text" class="subject" placeholder="Subject"
								name="subject" id="subject">
						</div>
						<div class="field textarea">
							<textarea class="message" cols="30" rows="10"
								placeholder="Message.." name="textbody" id="textbody"></textarea>
						</div>
						<div class="button-area">
							<button class="send-msg" type="submit" name="send">Send
								Mail</button>
						</div>
					</form>
				</div>
			</div>


			<div class="contact-content" style="margin-top: -7em;">
				<div class="column left"></div>
				<div class="column right" style="float: both">
					<div class="text">Get a Custom E-mail from Me</div>
					<form class="contact-form" action="mailInfo?action=receive"
						method="post">

						<div class="fields">
							<div class="field name">
								<input type="text" class="fullname" placeholder="Name"
									name="name" id="name">
							</div>
							<div class="field email">
								<input type="text" class="email-input" placeholder="Email"
									name="email" id="email">
							</div>
						</div>
						<div class="button-area">
							<button class="send-msg" type="submit" name="send">Get
								Mail</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>

	<br />

	</div>

	<span
		style="font-style: italic; font-size: 14px; font-weight: 50%; font-family: 'Poppins', sans-serif; text-align: center; display: block; margin-bottom: 2em;">All
		Rights Reserved</span>


	<script src="script.js"></script>

</body>
</html>
