# Grave Digging with JavaScript

## Introduction
This is a small demonstration repository for my application for a talk at
jsconf.eu. This repository is about showing off a long forgotten technology
available using the JavaPlugin: Live Connect.

Live Connect allows Java Script communicate with Java Applets and reverse.

This doesn't sound interesting until you add code signatures into the mix...

Digging a nearly two decades old technology out of its grave can be dangerous
as there will be Zombies!

The final state of this little project will use an invisible signed Java
Applet to expose the full node.js-Filesystem-API to your browser: Access any
file of the client machine directly from JavaScript using the nice
node.js-API!

## Building
For the applet to get access to the local filesystem, you will need to sign
the Applet. For additional effect, I'm signing this using a valid code signing
certificate of my company, which, apparently, I can't hand you out.

That means that you will have to create your own Java keystore with both a
private and a public key.

Then copy sign.properties.template to sign.properties, enter the correct data
(keystore-name, key alias and password).

Then run ant.

## Demo
Run demo/index.html over any webserver and enjoy.

## Implications
The idea behind my talk, aside of producing the initial effect of showing the
crowd **my /etc/passwd using a browser displaying a public website** is to
explain how this age-old technology works and how to use it for good.

Remember: The applet has to be signed, so malicious use can be directly
attributed to the author.

This is just to explain how 1x1 pixel sized applets, positioned somewhere
around -999,-999 can provide a tremendous use for people having to access any
kind of local hardware.

This even goes beyond what is in the Java JRE: I'm going to demonstrate how
you access a serial port to read a barcode-scanner, or how to use JNA to call
*any* native OS function.

Java UI sucks. HTML UI looks cool. Let's combine the power of full native
hardware access with the abilities of JavaScript to build really, really cool
stuff.

## License
All of the stuff here is © 2011 by Philip Hofstetter, but it's licensed under
the MIT license. I will write some documentation and highlight the caveats
regardless of whether the talk will be accepted or not, but for now, this has
to suffice.