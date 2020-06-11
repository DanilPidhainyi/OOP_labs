const FromSocket = require("./FromSocket");

class Charger extends FromSocket {
    constructor(name, electromagneticRadiation, power, isPowerOn) {
        super(name, electromagneticRadiation, power, isPowerOn);
    }

}

module.exports = Charger;