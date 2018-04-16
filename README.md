# SoundFont808.sc

```
f = FluidSynth(\jack, 16, 16); // multichan
f.setGain(0.95);
f.loadSoundfont(Platform.userExtensionDir +/+ "SoundFont808/sf2/FluidR3_GM_808.sf2");
f.selectInstruments([
    (\chan: 1, \sfont: 1, \bank: 128, \prog: 1), // bass drum
    (\chan: 2, \sfont: 1, \bank: 128, \prog: 2), // snare
    (\chan: 3, \sfont: 1, \bank: 128, \prog: 3), // lo tom
    (\chan: 4, \sfont: 1, \bank: 128, \prog: 4), // lo conga
    (\chan: 5, \sfont: 1, \bank: 128, \prog: 5), // mid tom
    (\chan: 6, \sfont: 1, \bank: 128, \prog: 6), // mid conga
    (\chan: 7, \sfont: 1, \bank: 128, \prog: 7), // hi tom
    (\chan: 8, \sfont: 1, \bank: 128, \prog: 8), // hi conga
    (\chan: 9, \sfont: 1, \bank: 128, \prog: 9), // claves
    (\chan: 10, \sfont: 1, \bank: 128, \prog: 10), // rimshot
    (\chan: 11, \sfont: 1, \bank: 128, \prog: 11), // maracas
    (\chan: 12, \sfont: 1, \bank: 128, \prog: 12), // clap
    (\chan: 13, \sfont: 1, \bank: 128, \prog: 13), // cow
    (\chan: 14, \sfont: 1, \bank: 128, \prog: 14), // cymbal
    (\chan: 15, \sfont: 1, \bank: 128, \prog: 15), // open hat
    (\chan: 0, \sfont: 1, \bank: 128, \prog: 16), // clsoe hat
]);
f.listChannels;
f.pr_send("reverb 0");
f.pr_send("chorus 0");
```
