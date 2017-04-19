var hue = require("node-hue-api"),
    HueApi = hue.HueApi,
    lightState = hue.lightState;

var displayResult = function(result) {
    console.log(result);
};

var displayError = function(err) {
    console.error(err);
};

var host = "192.168.86.111",
    username = "6hufLC0Cka15j3SI8Dsj5-1jeqfq5tP6w5-RIw20",
    api = new HueApi(host, username),
    state = lightState.create();


     // Set the lamp with id '4' to on
  api.setLightState(5, state.on(), function(err, result) {
	if (err) throw err;
	displayResult(result);
     });

// Now turn off the lamp
//api.setLightState(5, state.off(), function(err, result) {
//	if (err) throw err;
//	displayResult(result);
//});
      










