const ElectricalDevice = require("./ElectricalDevice");

class OnBatteries extends ElectricalDevice {
    constructor(name, electromagneticRadiation) {
        super(name, electromagneticRadiation);

    }
}

module.exports = OnBatteries;