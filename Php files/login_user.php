<?php
 
/*
 * Following code will create a new user  row
 * All user details are read from HTTP Post Request
 */
 

 
// check for required fields
if (isset($_POST['login']) && isset($_POST['password'])) 
{ 
	//temporarirly store the login and password
	$login = $_POST['login'];
	$password=$_POST['password'];
	
	// array for JSON response
	$response = array();
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
 
    // connecting to db
    $db = new DB_CONNECT();
    //search for th euser in the database
	$search =mysql_query("SELECT *FROM users WHERE login='$login' AND  password='$password'");
    // Mysql_num_row is counting table row
	$count=mysql_num_rows($search);
    //user exists if there are more than one row
    if ($count==1) {
	
		//while ($row = mysql_fetch_array($search)) 
		//{
		//$response["users"] = array();
        // temp user array
        //$user = array();
        //$user["pid"] = $row["pid"];
        //$user["name"] = $row["name"];
        //$user["age"] = $row["age"];
        //$user["school"] = $row["school"];
        //$user["total"] = $row["total"];
		
 
        // push single product into final response array
       // array_push($response["users"], $user);
		//}
	
        // sucess
        
		$response["success"] = 1;
		$response["message"] = "User  exists ";
        // echoing JSON response
        echo json_encode($response);
		
    }
	else {
    	
			// user does'nt exsists
			$response["success"] = 0;
			$response["message"] = "User doesn't exists ";
			}

        // echoing JSON response
        echo json_encode($response);
    }
	
 else {
    // required field is missing
    $response["success"] = 3;
    $response["message"] = "Required field(s) is missing";
 
    // echoing JSON response
    echo json_encode($response);
}
?>