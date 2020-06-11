const Toaster = require("./Toaster");
const Charger = require("./Charger");
const MicrowaveOven = require("./MicrowaveOven");
const Clock = require("./Clock");
const Phone = require("./Phone");
const Room = require("./Room");


// Варіант 2

/*
 Визначити ієрархію електроприладів.
 Увімкнути деякі електроприлади в розетку.
 Підрахувати споживану потужність.
 Провести сортування приладів у квартирі на основі потужності.
 Знайти прилад у квартирі, що відповідає заданому діапазону електор-магнітного випромінювання.
*/


const myRoom = new Room(
  new Toaster("Тостер", 10, 830, true),
  new Charger("Блок живлення", 2, 15, true),
  new MicrowaveOven("Мікрохвильова піч", 50, 1200, true),
  new Clock("Годинник", 0),
  new Phone("Телефон", 3)
);


// Вивід результатів
console.log(
    `Cпоживана потужність: ${myRoom.powerNetwork()}
     Cортування приладів у квартирі на основі потужності:
     ${myRoom.sortDevices().map(a => a.showPower())}
     Прилад у квартирі, що відповідає заданому діапазону
     електор-магнітного випромінювання: ${myRoom.findDevice(45, 55)}
`);
