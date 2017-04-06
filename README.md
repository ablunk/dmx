# Discrete-Event Simulation Modelling with Extensibility

![dmx logo](logo-small.png "dmx logo")

DMX is an approach that allows to define a domain-specific language (DSL) with process-oriented modelling concepts by extending a general-purpose base language. The base language is a process-oriented simulation language that is highly runtime efficient.

The approach consists of

1. the base language DBX, which was built for flexible extensibility, concise models, and highly efficient simulations,
2. a model editor that instantly supports extensions with syntax highlighting and content assistance,
3. a compiler for DBX models with extensions,
4. and a DBX model launcher.

The base language and the tooling are provided as a set of plugins for Eclipse. They require a set of other plugins:

- Eclipse Modeling Framework (EMF),
- [Xtend](http://www.eclipse.org/xtend) Version 2.4 or higher, [available from here](http://www.eclipse.org/xtend/download.html),
- and an adapted version of the Textual Editing Framework (TEF), originally developed by Markus Scheidgen, [available from this Eclipse update site](http://github.com/ablunk/dmx/raw/master/dev-plugins/hub.sam.tef.updatesite).

DMX is an academic project. I'm trying to have a stable version in the latest commit. However, there might be some parts not working from time to time. The purpose is to show the principle working of the particular concept of language extension which is realized by the approach.

In order to use DMX, you should import its plugins into your own Eclipse workspace. The contents provided at GitHub are listed below.

## Contents

- The folder [dev-plugins](https://github.com/ablunk/dmx/tree/master/dev-plugins) contains the framework as a set of Eclipse plugins. These plugins should be imported into your Eclipse workspace.
- The folder [runtime-plugins](https://github.com/ablunk/dmx/tree/master/runtime-plugins) contains an example project with a number of [DMX models](https://github.com/ablunk/dmx/tree/master/runtime-plugins/Examples/src-dmx). The project should be imported into the workspace of a second running Eclipse.

## Scientific Papers

- Blunk, A., Fischer, J.: [Prototyping SDL Extensions](https://www.mendeley.com/research/prototyping-sdl-extensions-1/). In: Proceedings of the 8th International Conference SAM 2014. Valencia, Spain. Springer (2014)
- Blunk, A., Fischer, J.: [A Highly Efficient Simulation Core in C ++](http://dl.acm.org/citation.cfm?id=2665013). In: DEVS '14 Proceedings of the Symposium on Theory of Modeling & Simulation. Tampa, Florida. Society for Computer Simulation International (2014)
- Blunk, A., Fischer, J.: [Efficient Development of Domain-specific Simulation Modelling Languages and Tools](https://www.mendeley.com/research/efficient-development-domainspecific-simulation-modelling-languages-tools/). In: Proceedings of the 16th International SDL Forum. Montreal, Canada. Springer (2013)
- Blunk, A., Fischer, J.: [Prototyping Domain Specific Languages as Extensions of a General Purpose Language.](http://www.mendeley.com/research/prototyping-domain-specific-languages-as-extensions-of-a-general-purpose-language-1/) In: 7th System Analysis and Modeling Workshop, Springer (2012)

## Documentation

[Workbench Overview](http://github.com/ablunk/dmx/raw/gh-pages/dmx-workbench.pdf)

## Videos

### Defining and Using a PrintLn Extension

[![PrintLn](http://img.youtube.com/vi/ccv8PJONop4/0.jpg)](https://youtu.be/ccv8PJONop4)

### Defining and Using a Simple Forever Extension

[![Forever](http://img.youtube.com/vi/shNhaSriWUE/0.jpg)](https://youtu.be/shNhaSriWUE)

## Contact

Having trouble with DMX? Contact me (Andreas Blunk) at andreas.blunk@gmail.com.
