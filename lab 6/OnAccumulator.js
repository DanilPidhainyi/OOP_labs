const ElectricalDevice = require("./ElectricalDevice");

class OnAccumulator extends ElectricalDevice {
    isPowerOn = false;
    constructor (name, power, electromagneticRadiation) {
        super(name, power, electromagneticRadiation);
    }

}

module.exports = OnAccumulator;