# crimpure

This is a Clojure implementation of [Crimp](https://github.com/BBC-News/crimp), the BBC News arbitrary data structure hashing tool.

The `notate` method returns a string showing the flattened and simplified data structure

The `signature` method returns the MD5 hash of that notation string

## How to run the tests

The project uses [Midje](https://github.com/marick/Midje/).

`lein midje` will run all tests.

`lein midje namespace.*` will run only tests beginning with "namespace.".

`lein midje :autotest` will run all the tests indefinitely. It sets up a
watcher on the code files. If they change, only the relevant tests will be
run again.
