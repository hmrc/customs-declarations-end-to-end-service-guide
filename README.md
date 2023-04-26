# Technical Documentation - Customs Declarations Service Guide

## Overview

This repository contains the source files that are used to generate the [Customs Declarations End-to-End Service Guide on the HMRC Developer Hub](https://developer.service.hmrc.gov.uk/guides/customs-declarations-end-to-end-service-guide).

## Editing Service Guide pages

To make changes, edit the files that are located in `./source/documentation`. All pages are written in [Markdown](https://en.wikipedia.org/wiki/Markdown).

To add new pages simply copy and paste one of the existing pages, it will automatically appear in the menu.

## Previewing

#### Option 1 - Using Docker (recommended)

Requirements:
* [Docker](https://www.docker.com/)

**Tip:** On macOS, use Homebrew to install [colima](https://github.com/abiosoft/colima) and then Docker client. Then start colima.

To live preview:
```
./batect preview
```
The local URL and port where the files can be previewed will be output, this is normally http://localhost:4567.

**Note:** The first time this is run it builds the Docker image and installs dependencies so may take 5 mins.
Subsequent runs will be much quicker.

#### Option 2 - Local install (Not recommended)

Requirements:
* [Ruby Version Manager][rbenv]
* [Node Version Manager][nodenv]

To live preview:
```
bundle install
bundle exec middleman serve
```
The local URL and port where the files can be previewed will be output, this is normally http://localhost:4567.

## Running the Scala Application

Requirements:
* Scala/sbt

### Build the HTML files
```
./batect build
```
### Run the Scala Application
```
sbt run
```

The local URL and port where the files can be previewed will be output, this is normally http://localhost:9000.

### How do I update the Ruby Gems
To update the Ruby Gems to the latest versions, run
```
./batect update
```
This will update the `Gemfile.lock`

### How do I change the Ruby version
Edit `.ruby-version` with the required version of Ruby.

### How do I change the Node version
Edit `.node-version` with the required version of Node.

[tdt]: https://github.com/alphagov/tech-docs-template
[rbenv]: https://github.com/rbenv/rbenv
[nodenv]: https://github.com/nodenv/nodenv

## License
This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html").
