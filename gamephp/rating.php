<?php
    include "config.php";
    session_start();
    
    if (isset($_GET['email'])) {
        $userid=($_GET['email']);
        $ratedIndex=$_GET['ratedIndex'];
        $_SESSION['userid']=$userid;
        $ratedIndex++;
        $sql = "SELECT `id`, `ratedIndex`, `email` FROM `stars` WHERE `email`='$userid'";

        $result = mysqli_query($connection, $sql);

        $row=mysqli_fetch_array($result);
        $id=$row["email"];
        echo $id;
        echo'<script type="text/javascript">','alert(".$id.");','</script>';

        // $checkid=$connection->query("SELECT id FROM `stars` WHERE email =''.$userid.'' ");
        
        if($id){
            $update=$connection->query("UPDATE `stars` SET `ratedIndex`='$ratedIndex'WHERE `email`='$userid'");
            echo'<script type="text/javascript">','alert("Updated Rating successfully");','</script>';
           header("Location: http://localhost/gamephp/index.php");
        }
        else{
            
            $connection->query("INSERT INTO `stars`(`ratedIndex`, `email`) VALUES ('$ratedIndex','$userid')");
            echo'<script type="text/javascript">','alert("Rating successfully");','</script>';
            header("Location: http://localhost/gamephp/index.php");
        }
        

        
    }
    
?>

