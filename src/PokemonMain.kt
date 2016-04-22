import PokeApiScraping.PokemonApiScraper

/**
 * Created by william on 4/18/16.
 */

fun main(args: Array<String>) {
    val scraper = PokemonApiScraper()
//    val moveDao = scraper.ScrapeMove(1)
//    print(moveDao.toString())
//    val move = Move(moveDao)

    val pokemonDao = scraper.ScrapePokemon(1)
    print(pokemonDao.toString())

}

