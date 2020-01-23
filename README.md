
https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050edf/0000000000051004

Pre-requisites: Java, Maven, Docker

1. Clone the repo https://github.com/nskanth987/scrambled-words
2. Open a terminal inside the project directory
3. For Running tests, run command: mvn test
4. To run the jar in docker, Please follow the below steps
	a. Build the jar using command: mvn package
	b. put the dictionary file in project folder with name -> dict.txt
	c. put the input file in project folder with name -> input.txt
	d. run the docker command to buid the image: docker build -t <image_name> .
	e. After building the image run the docker image: docker run <image_name>
