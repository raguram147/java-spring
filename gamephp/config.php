<?php
$connection = new mysqli("127.0.0.1:3307","root","root","portfolio");
if (! $connection){
    die("Error in connection".$connection->connect_error);
}