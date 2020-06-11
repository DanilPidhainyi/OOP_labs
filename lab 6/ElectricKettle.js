const FromSocket = require("./FromSocket");

class ElectricKettle extends FromSocket {
    constructor(name, power, electromagneticRadiation, isPowerOn) {
        super(name, power, electromagneticRadiation, isPowerOn);
    }

}

module.exports = ElectricKettle;