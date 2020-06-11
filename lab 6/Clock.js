const OnBatteries = require("./OnBatteries");

class Clock extends OnBatteries {
    constructor(name, electromagneticRadiation) {
        super(name, electromagneticRadiation);
    }

}

module.exports = Clock;
