<?php
 
/*
 * Following code will create a new user  row
 * All user details are read from HTTP Post Request
 */
 
// array for JSON response
$response = array();
 
// check for required fields
if (isset($_POST['name']) && isset($_POST['age']) && isset($_POST['school']) && isset($_POST['login']) && isset($_POST['password'])) 
{
    $name = $_POST['name'];
    $age = $_POST['age'];
    $school = $_POST['school'];
	$login = $_POST['login'];
	$password=$_POST['password'];
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
 
    // connecting to db
    $db = new DB_CONNECT();
    
		$search =mysql_query("SELECT *FROM users Where login='$login'");
   // Mysql_num_row is counting table row
		$count=mysql_num_rows($search);
    // check if row inserted or not
    if ($count==1) {
        // successfully inserted into database
        $response["success"] = 0;
        $response["message"] = "User already Exits";
        // echoing JSON response
        echo json_encode($response);
    }
	else {
    	// mysql inserting a new row
		$result = mysql_query("INSERT INTO users(name, age, school,login,password) VALUES('$name', '$age', '$school','$login','$password')");

			if($result){
			//sucessfully inserted 
			$response["success"] = 1;
			$response["message"] = "User Account created succesfully.";
			}
			else{
			// failed to insert row
			$response["success"] = 0;
			$response["message"] = "failed to create account";
			}

        // echoing JSON response
        echo json_encode($response);
    }
	}
 else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
 
    // echoing JSON response
    echo json_encode($response);
}
?>