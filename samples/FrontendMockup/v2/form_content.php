<?php
include 'config.php';

$PCM_Scenario = "1";
$PCM_Fragment = "1";
$PCM_options = "closed";

$get_json = file_get_contents($JEngine_Server_URL."/".$JCore_REST_Interface."/".$PCM_Scenario."/".$PCM_Fragment."/".$PCM_options);

//Exmaple JSON String: '{"ids":[2,4],"label":{"2":"Essen kochen","4":"Zutaten kaufen"}}';
$get_response = json_decode($get_json,true);

$response_amount_of_ids = count($get_response['ids']);
$response_label = $get_response['label'];

if($response_amount_of_ids == 0){
	die (" no ids provided");
}

?>

<li>Teil kleben</li>
<li>Teil transportieren</li>
<li>Teil schweißen</li>
<li><font color="green">Teil schrauben</font></li>

