SwingTesting
============

A few simple Java Swing things, using Swing.

Initially, I just wanted to make sure I could put a different JPanel into a JFrame.  Easy stuff.

Then, I wanted to make sure I could understand how to work the SwingWorker class.  I was a little
confused initially about how you managed to get the returned value from the get() method, because
I couldn't seem to manage to call it in a way that didn't block the entire application, which as
you probably know, is the entire point of using SwingWorker.  However, I figured it out - you
just get the done() method to call it, and pass it back to, say, the JFrame that contained the
button that was punched to call the long-running activity in the first place.
