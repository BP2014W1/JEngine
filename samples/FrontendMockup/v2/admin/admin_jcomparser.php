<?php
include '../core/config.php';
include '../core/RESTCalls.php';


$scenarios_array = GetAvailableScenarios();
$scenarios = $scenarios_array['ids'];

foreach ($scenarios as $scenario_value => $scenario_label) {
    echo "<a href='pcm_image.php?id=".$scenario_value."'><img src='pcm_image.php?id=".$scenario_value."' width='10%'></a><br>";
    echo "<hr>Scenario: <b> ".$scenario_label."</b> with the ID ".$scenario_value;
    echo "<form action='update_jcomparser.php'>
             <input type='hidden' name='scenarioID' value='".$scenario_value."'>
             <input type='submit' value='Submit'>
          </form> <br>";
}

?>
