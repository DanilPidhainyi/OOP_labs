const FromSocket = require("./FromSocket");

class Room {
    #devices = [];
    constructor(...devices) {
        this.#devices = devices;
    }

    get devices() {
        return this.#devices;
    }

    set devices(newDiv) {
        this.#devices = newDiv;
    }

    sortDevices(compareFn) {
        // сортування на основі потужності
        // найбільше ціле число js (2^53 - 1)
        return this.#devices.filter(item => item instanceof FromSocket)
                            .sort((a, b) => a.power - b.power);
    }

    powerNetwork() {
        // знайдимо суму всіх увімкнених в розетку проиладів
        return this.#devices.filter(item => item instanceof FromSocket &&
                                            item.isPowerOn)
                            .map(item => item.power)
                            .reduce((a, b) => a + b, 0);
    }

    findDevice(min, max) {
        // Знаходимо прилад у квартирі, що відповідає
        // заданому діапазону електор-магнітного випромінювання
        const findDiv = this.#devices.find(a => a.electromagneticRadiation > min &&
                                                a.electromagneticRadiation < max);
        return findDiv !== undefined ? findDiv.name : "не знайдено";
    }
}

module.exports = Room;