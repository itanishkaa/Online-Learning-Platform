import React from "react"
import './css/CustomJumbotron.css';
import { useNavigate } from "react-router-dom";
import { CardFooter, Card, CardTitle, CardText, Button, CardBody, CardHeader } from "reactstrap";

const Home = () => {
    const navigate = useNavigate();

    return (
        <div className="">
            <div className="custom-jumbotron">
                <h1>Welcome to Free Course App</h1>
                <p>
                    It is collection of free courses from youtube collected in one site, which is very usefull for students !!
                </p>
            </div>
            <div className="d-flex flex-wrap justify-content-center align-items-center text-center">
                <Card
                    className="my-2"
                    color="primary"
                    inverse
                    style={{
                        width: '18rem',
                        margin: 'auto'
                    }}
                >
                    <CardHeader>
                        Login
                    </CardHeader>
                    <CardBody>
                        <CardTitle tag="h5">
                            Admin Login
                        </CardTitle>
                        <CardText>
                            Add, Delete, Update Courses.
                        </CardText>
                    </CardBody>
                    <CardFooter>
                        <Button color="secondary" onClick={() => navigate("/adminLogin")}>
                            Login Here
                        </Button>
                    </CardFooter>
                </Card>
                <Card
                    className="my-2"
                    color="secondary"
                    inverse
                    style={{
                        width:'18rem',
                        margin:'auto'
                    }}
                >
                    <CardHeader>
                        Login
                    </CardHeader>
                    <CardBody>
                        <CardTitle tag="h5">User Login</CardTitle>
                        <CardText>Login to view courses</CardText>
                    </CardBody>
                    <CardFooter>
                        <Button color="primary" onClick={() => navigate("/login")}>Login Here</Button>
                    </CardFooter>
                </Card>
            </div>
        </div>
    );
};

export default Home;