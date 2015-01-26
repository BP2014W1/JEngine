<?php
include 'core/config.php';
include 'core/RESTCalls.php';
?>
<html>
<head>
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function(){    
            var a = $(this).attr('id');
            $.post("admin_db_lookup.php", {
            }, function(response){
                $('#container').fadeOut();
                $('#container').html(unescape(response));
                $('#container').fadeIn();
                setTimeout("finishAjax('container', '"+escape(response)+"')", 400);
            });  
    });    
    function finishAjax(id, response){
      $('#'+id).html(unescape(response));
      $('#'+id).fadeIn();
    } 
    </script> 
</head>
<body>

<?php
//update Cookie Values in case of POST is set.
if(isset($_POST["ScenarioID"])){
  setcookie("JEngine_ScenarioID", $_POST["ScenarioID"]);
  setcookie("JEngine_ScenarioInstanceID", $_POST["ScenarioInstanceID"]);
  setcookie("JEngine_ActivityID", $_POST["ActivityID"]);
  setcookie("JEngine_UserID", $_POST["UserID"]);
  echo "update successful.";
}

if(!isset($_COOKIE['JEngine_ScenarioID'])) {

  $JEngine_ScenarioInstanceID ="1";
  $JEngine_ActivityID = "1";
  $JEngine_UserID = rand(5, 100);
  $JEngine_ScenarioID = ShowScenarios();
  $JEngine_ScenarioID = $JEngine_ScenarioID["ids"][0];

  setcookie("JEngine_ScenarioID", $JEngine_ScenarioID);
  setcookie("JEngine_ScenarioInstanceID", $JEngine_ScenarioInstanceID);
  setcookie("JEngine_ActivityID", $JEngine_ActivityID);
  setcookie("JEngine_UserID", $JEngine_UserID);
  echo "generating user profile successful.<br>";
}

//if cookie is set, do ... else you could automatically generate IDs..
if(isset($_COOKIE['ScenarioID']) && $_COOKIE['JEngine_ScenarioInstanceID'] === "1") {

}

//print out form for editing values
echo"<form action='admin.php' method='post'>
        JEngine_ScenarioID: <input type='text' name='ScenarioID' value='".$_COOKIE['JEngine_ScenarioID']."'><br>
        JEngine_ScenarioInstanceID: <input type='text' name='ScenarioInstanceID' value='".$_COOKIE['JEngine_ScenarioInstanceID']."'><br>
        JEngine_ActivityID: <input type='text' name='ActivityID' value='".$_COOKIE['JEngine_ActivityID']."'><br>
        JEngine_UserID: <input type='text' name='UserID' value='".$_COOKIE['JEngine_UserID']."'><br>
      <input type='submit'>
    </form> ";


?>
<div id="container">
    <br><br><br>
    <i>waiting for HANA..</i><br><br><img src="img/loading-green.gif"><br><br><br><br><br><br><br>
</div>



