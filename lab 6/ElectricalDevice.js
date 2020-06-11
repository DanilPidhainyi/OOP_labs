class ElectricalDevice {
    #electromagneticRadiation = 0;
    #name;
    constructor(name, electromagneticRadiation){
        this.#name = name;
        this.#electromagneticRadiation = electromagneticRadiation;
    }

    get name() {
        return this.#name;
    }

    get electromagneticRadiation() {
        return this.#electromagneticRadiation;
    }

    set electromagneticRadiation(newElRad) {
        return this.#electromagneticRadiation = newElRad;
    }
}

module.exports = ElectricalDevice;

