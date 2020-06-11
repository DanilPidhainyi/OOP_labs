const ElectricalDevice = require("./ElectricalDevice");

class FromSocket extends ElectricalDevice {
    #isPowerOn;
    #power;
    constructor(name, electromagneticRadiation, power, isPowerOn) {
        super(name, electromagneticRadiation);
        this.#power = power;
        this.#isPowerOn = isPowerOn || false;
    }

    get power() {
        return this.#power
    }

    set power(newPower) {
        this.#power = newPower;
    }

    showPower() {
        return `${this.name} power=${this.power}`
    }

    get isPowerOn() {
        return this.#isPowerOn;
    }

}

module.exports = FromSocket;