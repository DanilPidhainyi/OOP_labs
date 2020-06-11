const FromSocket = require("./FromSocket");

class MicrowaveOven extends FromSocket {
    constructor(name, electromagneticRadiation, power, isPowerOn) {
        super(name, electromagneticRadiation, power, isPowerOn);
    }

}

module.exports = MicrowaveOven;