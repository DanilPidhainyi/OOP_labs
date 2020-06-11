const FromSocket = require("./FromSocket");

class Toaster extends FromSocket {
    constructor(name, electromagneticRadiation, power, isPowerOn) {
        super(name, electromagneticRadiation, power, isPowerOn);
    }

}

module.exports = Toaster;