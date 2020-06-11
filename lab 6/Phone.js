const OnAccumulator = require("./OnAccumulator");

class Phone extends OnAccumulator {
    constructor(name, electromagneticRadiation) {
        super(name, electromagneticRadiation);
    }
}

module.exports = Phone;