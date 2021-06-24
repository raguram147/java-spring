<?php
include "config.php";
if ($_POST['authProvider'] == "Google"){
    $authProvider = $_POST['authProvider'];
    $googleTockenId = $_POST['googleTockenId'];
    $name = $_POST['name'];
    $email = $_POST['email'];
    $profile = $_POST['profile'];
    $now = date('Y-m-d H:i:s');
    // Check whether the user data already exist in the database
    $queryCheck = "SELECT email FROM user WHERE authProvider = '$authProvider' AND email = '$email'";
    $resultCheck = $connection->query($queryCheck);
    if (!$resultCheck){
        $queryPerform = $connection->query("UPDATE user SET authProvider = '$authProvider',googleIdTocken = '$googleTockenId',name='$name',
        email='$email',profile='$profile',modified='$now' WHERE authProvider = '$authProvider' AND email='$email'");
    }else{
        $queryPerform = $connection->query("INSERT INTO `user`(`authProvider`, `googleIdTocken`, `name`, `email`, `profile`, `created`, `modified`) VALUES ('$authProvider','$googleTockenId','$name','$email','$profile','$now','$now')");
    }
    $finalResultset = $connection->query($queryPerform) or die("Error in query".$connection->error);
    if($finalResultset){
        echo "test^loggedIn";
    }
}


