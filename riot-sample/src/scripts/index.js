let consts = require('./common/constants.js');
let myTest = require('./test.js');
let a = new myTest('hoge');
a.say();


require('../tags/screen.tag');
riot.mount('*');

