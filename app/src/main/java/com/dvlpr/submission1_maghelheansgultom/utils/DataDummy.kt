package com.dvlpr.submission1_maghelheansgultom.utils

import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.MovieEntity
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.TVShowsEntity
import com.dvlpr.submission1_maghelheansgultom.data.source.remote.response.MovieResponse
import com.dvlpr.submission1_maghelheansgultom.data.source.remote.response.TVShowResponse

object DataDummy {
    fun generateDummyMovies(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity("m01",
        "A Star is Born",
        "Drama, Romance, Music",
        "75%",
        "Bradley Cooper",
        "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
        "10/05/2018",
                false,
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg")
        )

        movies.add(
            MovieEntity("m02",
        "Alita: Battle Angel",
        "Action, Science Fiction, Adventure",
        "72%",
        "Robert Rodriguez",
        "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
        "02/14/2019",
                false,
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg")
        )

        movies.add(
            MovieEntity("m03",
        "Aquaman",
        "Action, Adventure, Fantasy",
        "69%",
        "James Wan",
        "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
        "12/21/2018",
                false,
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg")
        )

        movies.add(
            MovieEntity("m04",
        "Bohemian Rhapsody",
        "Music, Drama, History",
        "80%",
        "Bryan Singer",
        "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
        "11/02/2018",
                false,
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg")
        )

        movies.add(
            MovieEntity("m05",
        "Cold Pursuit",
        "Action, Crime, Thriller",
        "57%",
        "Hans Petter Moland",
        "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
        "02/08/2019",
                false,
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg")
        )

        movies.add(
            MovieEntity("m06",
        "Creed II",
        "Drama",
        "69%",
        "Steven Caple Jr.",
        "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
        "11/21/2018",
                false,
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg")
        )

        movies.add(
            MovieEntity("m07",
        "Fantastic Beasts: The Crimes of Grindelwald",
        "Adventure, Fantasy, Drama",
        "69%",
        "David Yates",
        "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
        "11/16/2018",
                false,
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg")
        )

        movies.add(
            MovieEntity("m08",
        "Glass",
        "Thriller, Drama, Science Fiction",
        "67%",
        "M. Night Shyamalan",
        "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
        "01/18/2019",
                false,
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg")
        )

        movies.add(
            MovieEntity("m09",
        "How to Train Your Dragon: The Hidden World",
        "Animation, Family, Adventure",
        "78%",
        "Dean DeBlois",
        "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
        "01/09/2019",
                false,
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg")
        )

        movies.add(
            MovieEntity("m10",
        "Avengers: Infinity War",
        "Adventure, Action, Science Fiction",
        "83%",
        "Joe Russo",
        "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
        "04/27/2018",
                false,
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg")
        )

        return movies
    }

    fun generateDummyTVShows(): List<TVShowsEntity> {
        val tvShows = ArrayList<TVShowsEntity>()

        tvShows.add(
            TVShowsEntity("t01",
        "Arrow",
        "Crime, Drama, Mystery, Action, Adventure",
        "66%",
        "Greg Berlanti",
        "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
        "Ended",
                false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg")
        )

        tvShows.add(
            TVShowsEntity("t02",
        "Doom Patrol",
        "Science Fiction, Fantasy, Comedy, Drama",
        "76%",
        "Jeremy Carver",
        "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
        "Returning Series",
                false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg")
        )

        tvShows.add(
            TVShowsEntity("t03",
        "Dragon Ball",
        "Animation, Action, Adventure, Science Fiction, Fantasy",
        "81%",
        "Akira Toriyama",
        "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
        "Ended",
                false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg")
        )

        tvShows.add(
            TVShowsEntity("t04",
        "Fairy Tail",
        "Action, Adventure, Animation, Comedy, Science Fiction, Fantasy, Mystery",
        "78%",
        "Hiro Mashima",
        "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
        "Ended",
                false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/jsYTctFnK8ewomnUgcwhmsTkOum.jpg")
        )

        tvShows.add(
            TVShowsEntity("t05",
        "Family Guy",
        "Animation, Comedy",
        "70%",
        "Seth MacFarlane",
        "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
        "Returning Series",
                false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg")
        )

        tvShows.add(
            TVShowsEntity("t06",
        "The Flash",
        "Drama, Science Fiction, Fantasy",
        "77%",
        "Greg Berlanti",
        "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
        "Returning Series",
                false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg")
        )

        tvShows.add(
            TVShowsEntity("t07",
        "Game of Thrones",
        "Science Fiction, Fantasy, Drama, Action, Adventure",
        "84%",
        "David Benioff",
        "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
        "Ended",
                false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg")
        )

        tvShows.add(
            TVShowsEntity("t08",
        "Gotham",
        "Drama, Crime, Science Fiction, Fantasy",
        "75%",
        "Bruno Heller",
        "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
        "Ended",
                false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg")
        )

        tvShows.add(
            TVShowsEntity("t09",
        "Grey's Anatomy",
        "Drama",
        "82%",
        "Shonda Rhimes",
        "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
        "Returning Series",
                false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg")
        )

        tvShows.add(
            TVShowsEntity("t10",
        "Hanna",
        "Action, Adventure, Drama",
        "75%",
        "David Farr",
        "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
        "Returning Series",
                false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iYUtjx1EN4SVTgxd2TB4cZTGSQb.jpg")
        )

        return tvShows
    }

    fun generateRemoteDummyMovies(): List<MovieResponse> {
        val movies = ArrayList<MovieResponse>()

        movies.add(
            MovieResponse("m01",
            "A Star is Born",
            "Drama, Romance, Music",
            "75%",
            "Bradley Cooper",
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            "10/05/2018",
                false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg")
        )

        movies.add(
            MovieResponse("m02",
            "Alita: Battle Angel",
            "Action, Science Fiction, Adventure",
            "72%",
            "Robert Rodriguez",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "02/14/2019",
                false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg")
        )

        movies.add(MovieResponse("m03",
            "Aquaman",
            "Action, Adventure, Fantasy",
            "69%",
            "James Wan",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            "12/21/2018",
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg"))

        movies.add(MovieResponse("m04",
            "Bohemian Rhapsody",
            "Music, Drama, History",
            "80%",
            "Bryan Singer",
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
            "11/02/2018",
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"))

        movies.add(MovieResponse("m05",
            "Cold Pursuit",
            "Action, Crime, Thriller",
            "57%",
            "Hans Petter Moland",
            "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
            "02/08/2019",
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg"))

        movies.add(MovieResponse("m06",
            "Creed II",
            "Drama",
            "69%",
            "Steven Caple Jr.",
            "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
            "11/21/2018",
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg"))

        movies.add(MovieResponse("m07",
            "Fantastic Beasts: The Crimes of Grindelwald",
            "Adventure, Fantasy, Drama",
            "69%",
            "David Yates",
            "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
            "11/16/2018",
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg"))

        movies.add(MovieResponse("m08",
            "Glass",
            "Thriller, Drama, Science Fiction",
            "67%",
            "M. Night Shyamalan",
            "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
            "01/18/2019",
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg"))

        movies.add(MovieResponse("m09",
            "How to Train Your Dragon: The Hidden World",
            "Animation, Family, Adventure",
            "78%",
            "Dean DeBlois",
            "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
            "01/09/2019",
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg"))

        movies.add(MovieResponse("m10",
            "Avengers: Infinity War",
            "Adventure, Action, Science Fiction",
            "83%",
            "Joe Russo",
            "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
            "04/27/2018",
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"))

        return movies
    }

    fun generateRemoteDummyTvShows(): List<TVShowResponse> {
        val tvShows = ArrayList<TVShowResponse>()

        tvShows.add(TVShowResponse("t01",
            "Arrow",
            "Crime, Drama, Mystery, Action, Adventure",
            "66%",
            "Greg Berlanti",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            "Ended",
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg"))

        tvShows.add(TVShowResponse("t02",
            "Doom Patrol",
            "Science Fiction, Fantasy, Comedy, Drama",
            "76%",
            "Jeremy Carver",
            "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
            "Returning Series",
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg"))

        tvShows.add(TVShowResponse("t03",
            "Dragon Ball",
            "Animation, Action, Adventure, Science Fiction, Fantasy",
            "81%",
            "Akira Toriyama",
            "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
            "Ended",
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg"))

        tvShows.add(TVShowResponse("t04",
            "Fairy Tail",
            "Action, Adventure, Animation, Comedy, Science Fiction, Fantasy, Mystery",
            "78%",
            "Hiro Mashima",
            "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
            "Ended",
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/jsYTctFnK8ewomnUgcwhmsTkOum.jpg"))

        tvShows.add(TVShowResponse("t05",
            "Family Guy",
            "Animation, Comedy",
            "70%",
            "Seth MacFarlane",
            "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
            "Returning Series",
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg"))

        tvShows.add(TVShowResponse("t06",
            "The Flash",
            "Drama, Science Fiction, Fantasy",
            "77%",
            "Greg Berlanti",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            "Returning Series",
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg"))

        tvShows.add(TVShowResponse("t07",
            "Game of Thrones",
            "Science Fiction, Fantasy, Drama, Action, Adventure",
            "84%",
            "David Benioff",
            "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
            "Ended",
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg"))

        tvShows.add(TVShowResponse("t08",
            "Gotham",
            "Drama, Crime, Science Fiction, Fantasy",
            "75%",
            "Bruno Heller",
            "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
            "Ended",
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg"))

        tvShows.add(TVShowResponse("t09",
            "Grey's Anatomy",
            "Drama",
            "82%",
            "Shonda Rhimes",
            "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
            "Returning Series",
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg"))

        tvShows.add(TVShowResponse("t10",
            "Hanna",
            "Action, Adventure, Drama",
            "75%",
            "David Farr",
            "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
            "Returning Series",
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iYUtjx1EN4SVTgxd2TB4cZTGSQb.jpg"))

        return tvShows
    }
}