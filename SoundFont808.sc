/*
        SoundFont808 class
        .sf808 method for Symbol, String, SequenceableCollection

        (c) 2018 by Mauro <mauro@sdf.org>
        http://cyberpunk.com.ar/

        A class that returns associated MIDI notes according to General MIDI Level 2 based on TR-808 sounds.
        Along with this class I'm providing a stripped version of FluidR3_GM.sf2
        Reference:
        * https://www.midi.org/specifications/item/gm-level-1-sound-set
        * https://en.wikipedia.org/wiki/General_MIDI_Level_2#Drum_sounds
        * http://www.musescore.org/download/fluid-soundfont.tar.gz

*/

SoundFont808 {

  classvar <midiNotes;

  *new {
    |input|
    ^this.asMidiNote(input);
  }

  *initClass {
    midiNotes = (
      \bd: 36, // Bass Drum
      \sd: 38, // Snare Drum

      \lt: 45, // Low Tom
      \lc: 64, // Low Conga

      \mt: 48, // (high) Mid Tom
      \mc: 63, // Mid Conga

      \ht: 50, // High Tom
      \hc: 62, // High Conga

      \cl: 75, // CLaves
      \rs: 37, // RimShot

      \ma: 70, // MAracas
      \cp: 39, // hand ClaP

      \cb: 56, // CowBell
      \cy: 52, // CYmbal
      \oh: 46, // Open Hi-hat
      \ch: 42, // Closed Hi-hat
    );
  }

  *names {
    ^midiNotes.keys.asArray;
  }

  *parse {
    |input|
    // return...

    // rercusive funkyness
    if(input.isKindOf(Array) or: (input.isKindOf(List))) {
      ^input.collect({ |i| this.parse(i) });
    };

    // or the note
    if(midiNotes[input.asSymbol].isNil.not) {
      ^midiNotes[input.asSymbol];
    };

    // or a \rest
    if(input.isRest) {
      ^\rest;
    };

    // or whatever it was received
    ^input;
  }

}

+ Symbol {
  sf808 {
    ^SoundFont808.parse(this);
  }
}

+ String {
  sf808 {
    ^SoundFont808.parse(this);
  }
}

+ SequenceableCollection {
  sf808 {
    ^SoundFont808.parse(this);
  }
}