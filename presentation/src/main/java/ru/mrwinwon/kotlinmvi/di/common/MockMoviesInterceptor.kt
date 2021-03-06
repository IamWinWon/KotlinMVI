package ru.mrwinwon.kotlinmvi.di.common

import okhttp3.*
import ru.mrwinwon.kotlinmvi.BuildConfig

/**
 * Created by Artem Winokurov on 09.05.2021.
 * MrWinWon
 * artem_winokurov@mail.ru
 */
class MockMoviesInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (BuildConfig.DEBUG) {
            val uri = chain.request().url().uri().toString()
//            val responseString = when {
//                uri.endsWith("starred") -> getListOfReposBeingStarredJson
//                else -> ""
//            }

            val responseString = getListOfReposBeingStarredJson;

            return chain.proceed(chain.request())
                .newBuilder()
                .code(200)
                .protocol(Protocol.HTTP_2)
                .message(responseString)
                .body(
                    ResponseBody.create(
                        MediaType.parse("application/json"),
                    responseString.toByteArray()))
                .addHeader("content-type", "application/json")
                .build()
        } else {
            //just to be on safe side.
            throw IllegalAccessError("MockInterceptor is only meant for Testing Purposes and " +
                    "bound to be used only with DEBUG mode")
        }
    }

}

const val getListOfReposBeingStarredJson = """
{
    "movies": [
        {
            "id": 368539,
            "id_kinopoisk": 1003587,
            "url": "27832-gamilton-2015",
            "type": "movie",
            "title": "Гамильтон",
            "title_alternative": "Hamilton",
            "year": 2015,
            "poster": "//images.kinopoisk.cloud/posters/1003587.jpg",
            "trailer": "https://www.youtube.com/embed/5snjgB9PO48",
            "actors": [
                "Лин-Мануэль Миранда",
                "Лесли Одом мл.",
                "Давид Диггс",
                "Филлипа Су",
                "Рене Голдсберри",
                "Окьерете Онаодован",
                "Энтони Рамос",
                "Джонатан Грофф",
                "Кристофер Нил Джексон",
                "Жасмин Сепас Джонс"
            ],
            "countries": [
                "США"
            ],
            "genres": [
                "Мюзикл"
            ],
            "directors": [
                "Томас Каил"
            ],
            "screenwriters": [
                "Лин-Мануэль Миранда",
                "Ron Chernow"
            ],
            "producers": [
                "Джилл Фурман",
                "Sander Jacobs",
                "Лин-Мануэль Миранда"
            ],
            "composers": [
                "Alex Lacamoire"
            ],
            "painters": [
                "Пол Тэйзуэлл"
            ],
            "rating_kinopoisk": "9.261",
            "kinopoisk_votes": "510",
            "premiere_world": "6 августа 2015",
            "frames": [
                "https://st.kp.yandex.net/im/kadr/2/8/2/kinopoisk.ru-Hamilton-2825620.jpg",
                "https://st.kp.yandex.net/im/kadr/2/8/2/kinopoisk.ru-Hamilton-2825621.jpg",
                "https://st.kp.yandex.net/im/kadr/2/8/2/kinopoisk.ru-Hamilton-2825622.jpg",
                "https://st.kp.yandex.net/im/kadr/2/8/2/kinopoisk.ru-Hamilton-2825623.jpg",
                "https://st.kp.yandex.net/im/kadr/2/8/2/kinopoisk.ru-Hamilton-2825624.jpg",
                "https://st.kp.yandex.net/im/kadr/2/8/2/kinopoisk.ru-Hamilton-2825625.jpg",
                "https://st.kp.yandex.net/im/kadr/2/8/2/kinopoisk.ru-Hamilton-2826010.jpg",
                "https://st.kp.yandex.net/im/kadr/2/8/2/kinopoisk.ru-Hamilton-2826011.jpg",
                "https://st.kp.yandex.net/im/kadr/2/8/2/kinopoisk.ru-Hamilton-2826012.jpg",
                "https://st.kp.yandex.net/im/kadr/2/8/2/kinopoisk.ru-Hamilton-2826013.jpg",
                "https://st.kp.yandex.net/im/kadr/2/8/2/kinopoisk.ru-Hamilton-2826014.jpg",
                "https://st.kp.yandex.net/im/kadr/2/8/2/kinopoisk.ru-Hamilton-2826015.jpg",
                "https://st.kp.yandex.net/im/kadr/2/8/2/kinopoisk.ru-Hamilton-2826016.jpg",
                "https://st.kp.yandex.net/im/kadr/2/8/2/kinopoisk.ru-Hamilton-2826017.jpg",
                "https://st.kp.yandex.net/im/kadr/2/8/2/kinopoisk.ru-Hamilton-2826018.jpg",
                "https://st.kp.yandex.net/im/kadr/2/8/3/kinopoisk.ru-Hamilton-2835192.jpg"
            ],
            "videocdn": {},
            "hdvb": {},
            "collapse": {},
            "kodik": {}
        },
        {
            "id": 39843,
            "id_kinopoisk": 45319,
            "url": "408479-zhil-byl-pes-1982",
            "type": "movie",
            "title": "Жил-был пёс",
            "description": "Жил-был пёс. Верно служил, но выгнали его по старости. И решил он повеситься, да повстречал в лесу такого же старого волка\u0085",
            "year": 1982,
            "poster": "//images.kinopoisk.cloud/posters/45319.jpg",
            "trailer": "https://www.youtube.com/embed/twSn58BPgWM",
            "age": "зрителям, достигшим 6 лет",
            "actors": [
                "Георгий Бурков",
                "Армен Джигарханян",
                "Эдуард Назаров"
            ],
            "countries": [
                "СССР"
            ],
            "genres": [
                "Мультфильм",
                "Короткометражка",
                "Комедия",
                "Семейный"
            ],
            "directors": [
                "Эдуард Назаров"
            ],
            "screenwriters": [
                "Эдуард Назаров"
            ],
            "operators": [
                "Михаил Друян"
            ],
            "painters": [
                "Алла Горева",
                "Эдуард Назаров"
            ],
            "rating_kinopoisk": "9.196",
            "rating_imdb": "8.6",
            "kinopoisk_votes": "75750",
            "imdb_votes": "2885",
            "premiere_world": "12 июля 2016",
            "frames": [
                "https://st.kp.yandex.net/im/kadr/3/6/1/kinopoisk.ru-Zhil-byl-pyos-361251.jpg",
                "https://st.kp.yandex.net/im/kadr/3/6/1/kinopoisk.ru-Zhil-byl-pyos-361252.jpg",
                "https://st.kp.yandex.net/im/kadr/3/6/1/kinopoisk.ru-Zhil-byl-pyos-361253.jpg",
                "https://st.kp.yandex.net/im/kadr/3/6/1/kinopoisk.ru-Zhil-byl-pyos-361254.jpg",
                "https://st.kp.yandex.net/im/kadr/3/6/1/kinopoisk.ru-Zhil-byl-pyos-361255.jpg",
                "https://st.kp.yandex.net/im/kadr/3/6/1/kinopoisk.ru-Zhil-byl-pyos-361256.jpg",
                "https://st.kp.yandex.net/im/kadr/3/6/1/kinopoisk.ru-Zhil-byl-pyos-361257.jpg",
                "https://st.kp.yandex.net/im/kadr/2/6/9/kinopoisk.ru-Zhil-byl-pyos-2698822.jpg",
                "https://st.kp.yandex.net/im/kadr/2/6/9/kinopoisk.ru-Zhil-byl-pyos-2698823.jpg"
            ],
            "videocdn": {},
            "hdvb": {},
            "collapse": {},
            "kodik": {}
        },
        {
            "id": 520468,
            "id_kinopoisk": 326,
            "url": "529004-pobeg-iz-shoushenka-1994",
            "type": "movie",
            "title": "Побег из Шоушенка",
            "title_alternative": "The Shawshank Redemption",
            "tagline": "«Страх - это кандалы. Надежда - это свобода»",
            "description": "Бухгалтер Энди Дюфрейн обвинён в убийстве собственной жены и её любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решётки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. Но Энди, обладающий живым умом и доброй душой, находит подход как к заключённым, так и к охранникам, добиваясь их особого к себе расположения.",
            "year": 1994,
            "poster": "//images.kinopoisk.cloud/posters/326.jpg",
            "trailer": "https://www.youtube.com/embed/m_0oN0jgsg8",
            "age": "зрителям, достигшим 16 лет",
            "actors": [
                "Тим Роббинс",
                "Морган Фриман",
                "Боб Гантон",
                "Уильям Сэдлер",
                "Клэнси Браун",
                "Джил Беллоуз",
                "Марк Ролстон",
                "Джеймс Уитмор",
                "Джеффри ДеМанн",
                "Ларри Бранденбург",
                "Диомид Виноградов",
                "Игорь Старосельцев",
                "Никита Прозоровский",
                "Олег Вирозуб",
                "Василий Дахненко"
            ],
            "countries": [
                "США"
            ],
            "genres": [
                "Драма"
            ],
            "directors": [
                "Фрэнк Дарабонт"
            ],
            "screenwriters": [
                "Фрэнк Дарабонт",
                "Стивен Кинг"
            ],
            "producers": [
                "Лиз Глоцер",
                "Дэвид В. Лестер",
                "Ники Марвин"
            ],
            "operators": [
                "Роджер Дикинс"
            ],
            "composers": [
                "Томас Ньюман"
            ],
            "painters": [
                "Теренс Марш",
                "Soheil",
                "Питер Лэндсдаун Смит"
            ],
            "editors": [
                "Ричард Фрэнсис-Брюс"
            ],
            "budget": "${'$'}25000000",
            "rating_kinopoisk": "9.1",
            "rating_imdb": "9.3",
            "fees_world": "${'$'}28418687",
            "fees_russia": "${'$'}87432",
            "premiere_world": "10 сентября 1994",
            "premiere_russia": "24 октября 2019",
            "frames": [
                "https://st.kp.yandex.net/im/kadr/4/4/8/kinopoisk.ru-The-Shawshank-Redemption-44864.jpg",
                "https://st.kp.yandex.net/im/kadr/4/4/8/kinopoisk.ru-The-Shawshank-Redemption-44865.jpg",
                "https://st.kp.yandex.net/im/kadr/4/4/8/kinopoisk.ru-The-Shawshank-Redemption-44866.jpg",
                "https://st.kp.yandex.net/im/kadr/4/4/8/kinopoisk.ru-The-Shawshank-Redemption-44867.jpg",
                "https://st.kp.yandex.net/im/kadr/4/4/8/kinopoisk.ru-The-Shawshank-Redemption-44868.jpg",
                "https://st.kp.yandex.net/im/kadr/4/4/8/kinopoisk.ru-The-Shawshank-Redemption-44869.jpg",
                "https://st.kp.yandex.net/im/kadr/4/4/8/kinopoisk.ru-The-Shawshank-Redemption-44870.jpg",
                "https://st.kp.yandex.net/im/kadr/5/3/1/kinopoisk.ru-The-Shawshank-Redemption-531686.jpg",
                "https://st.kp.yandex.net/im/kadr/5/3/1/kinopoisk.ru-The-Shawshank-Redemption-531687.jpg",
                "https://st.kp.yandex.net/im/kadr/5/3/1/kinopoisk.ru-The-Shawshank-Redemption-531689.jpg",
                "https://st.kp.yandex.net/im/kadr/5/3/1/kinopoisk.ru-The-Shawshank-Redemption-531690.jpg",
                "https://st.kp.yandex.net/im/kadr/5/3/1/kinopoisk.ru-The-Shawshank-Redemption-531691.jpg",
                "https://st.kp.yandex.net/im/kadr/5/3/1/kinopoisk.ru-The-Shawshank-Redemption-531692.jpg",
                "https://st.kp.yandex.net/im/kadr/5/3/1/kinopoisk.ru-The-Shawshank-Redemption-531693.jpg",
                "https://st.kp.yandex.net/im/kadr/5/3/1/kinopoisk.ru-The-Shawshank-Redemption-531695.jpg",
                "https://st.kp.yandex.net/im/kadr/9/2/4/kinopoisk.ru-The-Shawshank-Redemption-924911.jpg",
                "https://st.kp.yandex.net/im/kadr/9/2/4/kinopoisk.ru-The-Shawshank-Redemption-924912.jpg",
                "https://st.kp.yandex.net/im/kadr/9/2/4/kinopoisk.ru-The-Shawshank-Redemption-924913.jpg",
                "https://st.kp.yandex.net/im/kadr/9/2/4/kinopoisk.ru-The-Shawshank-Redemption-924914.jpg",
                "https://st.kp.yandex.net/im/kadr/9/2/4/kinopoisk.ru-The-Shawshank-Redemption-924915.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/7/kinopoisk.ru-The-Shawshank-Redemption-1477323.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/7/kinopoisk.ru-The-Shawshank-Redemption-1477324.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/7/kinopoisk.ru-The-Shawshank-Redemption-1477325.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/7/kinopoisk.ru-The-Shawshank-Redemption-1477326.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/7/kinopoisk.ru-The-Shawshank-Redemption-1477327.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/7/kinopoisk.ru-The-Shawshank-Redemption-1477328.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/7/kinopoisk.ru-The-Shawshank-Redemption-1477332.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/7/kinopoisk.ru-The-Shawshank-Redemption-1477333.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/7/kinopoisk.ru-The-Shawshank-Redemption-1477334.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/7/kinopoisk.ru-The-Shawshank-Redemption-1477335.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/7/kinopoisk.ru-The-Shawshank-Redemption-1477336.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/7/kinopoisk.ru-The-Shawshank-Redemption-1477337.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/7/kinopoisk.ru-The-Shawshank-Redemption-1477338.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/7/kinopoisk.ru-The-Shawshank-Redemption-1477339.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/7/kinopoisk.ru-The-Shawshank-Redemption-1477340.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/7/kinopoisk.ru-The-Shawshank-Redemption-1477341.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/7/kinopoisk.ru-The-Shawshank-Redemption-1477342.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/7/kinopoisk.ru-The-Shawshank-Redemption-1477343.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/7/kinopoisk.ru-The-Shawshank-Redemption-1477344.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/7/kinopoisk.ru-The-Shawshank-Redemption-1477345.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/7/kinopoisk.ru-The-Shawshank-Redemption-1477346.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/7/kinopoisk.ru-The-Shawshank-Redemption-1477347.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/7/kinopoisk.ru-The-Shawshank-Redemption-1477348.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/8/kinopoisk.ru-The-Shawshank-Redemption-1485749.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/8/kinopoisk.ru-The-Shawshank-Redemption-1485750.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/8/kinopoisk.ru-The-Shawshank-Redemption-1485751.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/8/kinopoisk.ru-The-Shawshank-Redemption-1485752.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/8/kinopoisk.ru-The-Shawshank-Redemption-1485754.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/8/kinopoisk.ru-The-Shawshank-Redemption-1485757.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/8/kinopoisk.ru-The-Shawshank-Redemption-1485758.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/8/kinopoisk.ru-The-Shawshank-Redemption-1485759.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/8/kinopoisk.ru-The-Shawshank-Redemption-1485760.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/8/kinopoisk.ru-The-Shawshank-Redemption-1485761.jpg",
                "https://st.kp.yandex.net/im/kadr/1/5/2/kinopoisk.ru-The-Shawshank-Redemption-1523739.jpg",
                "https://st.kp.yandex.net/im/kadr/1/5/2/kinopoisk.ru-The-Shawshank-Redemption-1523740.jpg",
                "https://st.kp.yandex.net/im/kadr/1/5/2/kinopoisk.ru-The-Shawshank-Redemption-1523741.jpg",
                "https://st.kp.yandex.net/im/kadr/1/5/2/kinopoisk.ru-The-Shawshank-Redemption-1523742.jpg",
                "https://st.kp.yandex.net/im/kadr/1/5/2/kinopoisk.ru-The-Shawshank-Redemption-1523743.jpg",
                "https://st.kp.yandex.net/im/kadr/1/5/2/kinopoisk.ru-The-Shawshank-Redemption-1523744.jpg"
            ],
            "screenshots": [
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132882.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132883.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132885.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132887.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132889.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132890.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132891.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132892.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132894.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132896.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132901.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132902.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132903.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132906.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132907.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132910.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132911.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132914.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132916.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132918.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132919.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132922.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132924.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132925.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132929.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132930.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132932.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132933.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132936.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132937.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132940.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132941.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132944.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132945.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132947.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132948.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132950.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132951.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132953.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132955.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132957.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132959.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132961.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132964.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132965.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132967.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132969.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132971.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132974.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132976.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132977.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132980.jpg",
                "https://st.kp.yandex.net/im/kadr/1/1/3/kinopoisk.ru-The-Shawshank-Redemption-1132981.jpg"
            ],
            "videocdn": {
                "url": [
                    "/movie/b00eabf79a13cf75ebbfde77257b7437/iframe"
                ],
                "quality": [
                    "HDRip"
                ],
                "voice": [
                    "Дубляж"
                ]
            },
            "hdvb": {},
            "collapse": {
                "url": [
                    "/embed/movie/162"
                ],
                "quality": [
                    "HD (720p)"
                ],
                "duration": [
                    "142 мин. / 02:22"
                ],
                "voice": [
                    "Рус. Проф. многоголосый",
                    "Eng.Original"
                ]
            },
            "kodik": {}
        },
        {
            "id": 21156,
            "id_kinopoisk": 435,
            "url": "257784-zelenaya-milya-1999",
            "type": "movie",
            "title": "Зеленая миля",
            "title_alternative": "The Green Mile",
            "tagline": "«Пол Эджкомб не верил в чудеса. Пока не столкнулся с одним из них»",
            "description": "Пол Эджкомб \u0097 начальник блока смертников в тюрьме «Холодная гора», каждый из узников которого однажды проходит «зеленую милю» по пути к месту казни. Пол повидал много заключённых и надзирателей за время работы. Однако гигант Джон Коффи, обвинённый в страшном преступлении, стал одним из самых необычных обитателей блока.",
            "year": 1999,
            "poster": "//images.kinopoisk.cloud/posters/435.jpg",
            "trailer": "https://www.youtube.com/embed/slOOxl8xaq0",
            "age": "зрителям, достигшим 16 лет",
            "actors": [
                "Том Хэнкс",
                "Дэвид Морс",
                "Бонни Хант",
                "Майкл Кларк Дункан",
                "Джеймс Кромуэлл",
                "Майкл Джитер",
                "Грэм Грин",
                "Даг Хатчисон",
                "Сэм Рокуэлл",
                "Барри Пеппер",
                "Всеволод Кузнецов",
                "Владимир Антоник",
                "Любовь Германова",
                "Валентин Голубенко",
                "Александр Белявский"
            ],
            "countries": [
                "США"
            ],
            "genres": [
                "Фантастика",
                "Драма",
                "Криминал",
                "Детектив"
            ],
            "directors": [
                "Фрэнк Дарабонт"
            ],
            "screenwriters": [
                "Фрэнк Дарабонт",
                "Стивен Кинг"
            ],
            "producers": [
                "Фрэнк Дарабонт",
                "Дэвид Валдес"
            ],
            "operators": [
                "Дэвид Тэттерсолл"
            ],
            "composers": [
                "Томас Ньюман"
            ],
            "painters": [
                "Теренс Марш",
                "Уильям Крус",
                "Керин Вагнер"
            ],
            "editors": [
                "Ричард Фрэнсис-Брюс"
            ],
            "budget": "${'$'}60000000",
            "rating_kinopoisk": "9.1",
            "rating_imdb": "8.6",
            "fees_world": "${'$'}286801374",
            "premiere_world": "6 декабря 1999",
            "premiere_russia": "18 апреля 2000",
            "frames": [
                "https://st.kp.yandex.net/im/kadr/1/6/2/kinopoisk.ru-The-Green-Mile-16202.jpg",
                "https://st.kp.yandex.net/im/kadr/1/6/2/kinopoisk.ru-The-Green-Mile-16205.jpg",
                "https://st.kp.yandex.net/im/kadr/9/4/4/kinopoisk.ru-The-Green-Mile-944558.jpg",
                "https://st.kp.yandex.net/im/kadr/9/4/4/kinopoisk.ru-The-Green-Mile-944559.jpg",
                "https://st.kp.yandex.net/im/kadr/9/4/4/kinopoisk.ru-The-Green-Mile-944560.jpg",
                "https://st.kp.yandex.net/im/kadr/9/4/4/kinopoisk.ru-The-Green-Mile-944561.jpg",
                "https://st.kp.yandex.net/im/kadr/9/4/4/kinopoisk.ru-The-Green-Mile-944562.jpg",
                "https://st.kp.yandex.net/im/kadr/9/4/4/kinopoisk.ru-The-Green-Mile-944563.jpg",
                "https://st.kp.yandex.net/im/kadr/9/4/4/kinopoisk.ru-The-Green-Mile-944564.jpg",
                "https://st.kp.yandex.net/im/kadr/9/4/4/kinopoisk.ru-The-Green-Mile-944565.jpg",
                "https://st.kp.yandex.net/im/kadr/9/4/4/kinopoisk.ru-The-Green-Mile-944566.jpg",
                "https://st.kp.yandex.net/im/kadr/9/4/4/kinopoisk.ru-The-Green-Mile-944567.jpg",
                "https://st.kp.yandex.net/im/kadr/9/4/4/kinopoisk.ru-The-Green-Mile-944568.jpg",
                "https://st.kp.yandex.net/im/kadr/9/4/4/kinopoisk.ru-The-Green-Mile-944569.jpg",
                "https://st.kp.yandex.net/im/kadr/1/3/5/kinopoisk.ru-The-Green-Mile-1353890.jpg",
                "https://st.kp.yandex.net/im/kadr/1/3/5/kinopoisk.ru-The-Green-Mile-1353891.jpg",
                "https://st.kp.yandex.net/im/kadr/1/3/5/kinopoisk.ru-The-Green-Mile-1353893.jpg",
                "https://st.kp.yandex.net/im/kadr/1/3/5/kinopoisk.ru-The-Green-Mile-1353894.jpg",
                "https://st.kp.yandex.net/im/kadr/1/3/5/kinopoisk.ru-The-Green-Mile-1353895.jpg",
                "https://st.kp.yandex.net/im/kadr/1/3/5/kinopoisk.ru-The-Green-Mile-1353896.jpg",
                "https://st.kp.yandex.net/im/kadr/1/3/5/kinopoisk.ru-The-Green-Mile-1353897.jpg",
                "https://st.kp.yandex.net/im/kadr/1/3/5/kinopoisk.ru-The-Green-Mile-1353898.jpg",
                "https://st.kp.yandex.net/im/kadr/1/3/5/kinopoisk.ru-The-Green-Mile-1353899.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/9/kinopoisk.ru-The-Green-Mile-1493530.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/9/kinopoisk.ru-The-Green-Mile-1493532.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/9/kinopoisk.ru-The-Green-Mile-1493533.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/9/kinopoisk.ru-The-Green-Mile-1493534.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/9/kinopoisk.ru-The-Green-Mile-1493535.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/9/kinopoisk.ru-The-Green-Mile-1493536.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/9/kinopoisk.ru-The-Green-Mile-1493537.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/9/kinopoisk.ru-The-Green-Mile-1493538.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/9/kinopoisk.ru-The-Green-Mile-1493539.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/9/kinopoisk.ru-The-Green-Mile-1493540.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/9/kinopoisk.ru-The-Green-Mile-1493541.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/9/kinopoisk.ru-The-Green-Mile-1493542.jpg",
                "https://st.kp.yandex.net/im/kadr/1/4/9/kinopoisk.ru-The-Green-Mile-1493543.jpg",
                "https://st.kp.yandex.net/im/kadr/1/5/2/kinopoisk.ru-The-Green-Mile-1523641.jpg",
                "https://st.kp.yandex.net/im/kadr/1/5/2/kinopoisk.ru-The-Green-Mile-1523642.jpg",
                "https://st.kp.yandex.net/im/kadr/1/5/2/kinopoisk.ru-The-Green-Mile-1523643.jpg",
                "https://st.kp.yandex.net/im/kadr/1/5/2/kinopoisk.ru-The-Green-Mile-1523644.jpg",
                "https://st.kp.yandex.net/im/kadr/1/5/2/kinopoisk.ru-The-Green-Mile-1523645.jpg",
                "https://st.kp.yandex.net/im/kadr/1/5/2/kinopoisk.ru-The-Green-Mile-1523646.jpg",
                "https://st.kp.yandex.net/im/kadr/2/7/0/kinopoisk.ru-The-Green-Mile-2709019.jpg",
                "https://st.kp.yandex.net/im/kadr/2/7/0/kinopoisk.ru-The-Green-Mile-2709020.jpg",
                "https://st.kp.yandex.net/im/kadr/2/7/0/kinopoisk.ru-The-Green-Mile-2709021.jpg",
                "https://st.kp.yandex.net/im/kadr/2/7/0/kinopoisk.ru-The-Green-Mile-2709022.jpg",
                "https://st.kp.yandex.net/im/kadr/2/7/0/kinopoisk.ru-The-Green-Mile-2709023.jpg",
                "https://st.kp.yandex.net/im/kadr/2/7/0/kinopoisk.ru-The-Green-Mile-2709024.jpg",
                "https://st.kp.yandex.net/im/kadr/2/7/0/kinopoisk.ru-The-Green-Mile-2709025.jpg",
                "https://st.kp.yandex.net/im/kadr/2/7/0/kinopoisk.ru-The-Green-Mile-2709026.jpg",
                "https://st.kp.yandex.net/im/kadr/2/7/0/kinopoisk.ru-The-Green-Mile-2709027.jpg",
                "https://st.kp.yandex.net/im/kadr/2/7/0/kinopoisk.ru-The-Green-Mile-2709028.jpg",
                "https://st.kp.yandex.net/im/kadr/2/7/0/kinopoisk.ru-The-Green-Mile-2709029.jpg",
                "https://st.kp.yandex.net/im/kadr/2/7/0/kinopoisk.ru-The-Green-Mile-2709030.jpg",
                "https://st.kp.yandex.net/im/kadr/2/7/0/kinopoisk.ru-The-Green-Mile-2709031.jpg",
                "https://st.kp.yandex.net/im/kadr/2/7/0/kinopoisk.ru-The-Green-Mile-2709032.jpg",
                "https://st.kp.yandex.net/im/kadr/2/7/0/kinopoisk.ru-The-Green-Mile-2709033.jpg",
                "https://st.kp.yandex.net/im/kadr/2/7/0/kinopoisk.ru-The-Green-Mile-2709034.jpg",
                "https://st.kp.yandex.net/im/kadr/2/7/0/kinopoisk.ru-The-Green-Mile-2709035.jpg",
                "https://st.kp.yandex.net/im/kadr/2/7/0/kinopoisk.ru-The-Green-Mile-2709036.jpg",
                "https://st.kp.yandex.net/im/kadr/2/7/0/kinopoisk.ru-The-Green-Mile-2709037.jpg",
                "https://st.kp.yandex.net/im/kadr/2/7/0/kinopoisk.ru-The-Green-Mile-2709038.jpg"
            ],
            "screenshots": [
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234119.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234120.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234121.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234122.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234123.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234124.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234125.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234126.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234127.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234128.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234129.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234130.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234131.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234132.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234133.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234134.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234135.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234136.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234137.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234138.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234139.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234140.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234141.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234142.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234143.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234144.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234145.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234146.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234147.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234148.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234149.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234150.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234151.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234152.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234153.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234154.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234155.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234156.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234157.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234158.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234159.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234160.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234161.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234162.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234163.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234164.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234165.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234166.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234167.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234168.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234169.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234170.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234171.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234172.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234173.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234174.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234175.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234176.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234177.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234178.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234179.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234180.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234181.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234182.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234183.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234184.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234185.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234186.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234187.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234188.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234189.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234190.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234191.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234192.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234193.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234194.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234195.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234196.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234197.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234198.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234199.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234200.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234201.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234202.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234203.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234204.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234205.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234206.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234207.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234208.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234209.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234210.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234211.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234212.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234213.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234214.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234215.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234216.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234217.jpg",
                "https://st.kp.yandex.net/im/kadr/1/2/3/kinopoisk.ru-The-Green-Mile-1234218.jpg",
                "https://st.kp.yandex.net/im/kadr/2/8/1/kinopoisk.ru-The-Green-Mile-2810718.jpg",
                "https://st.kp.yandex.net/im/kadr/2/8/1/kinopoisk.ru-The-Green-Mile-2810719.jpg",
                "https://st.kp.yandex.net/im/kadr/2/8/1/kinopoisk.ru-The-Green-Mile-2810720.jpg",
                "https://st.kp.yandex.net/im/kadr/2/8/1/kinopoisk.ru-The-Green-Mile-2810721.jpg",
                "https://st.kp.yandex.net/im/kadr/2/8/1/kinopoisk.ru-The-Green-Mile-2810722.jpg"
            ],
            "videocdn": {
                "url": [
                    "/movie/83e2bc427c8f9c652ad4d06320f276f5/iframe"
                ],
                "quality": [
                    "BluRay"
                ],
                "voice": [
                    "Дубляж"
                ]
            },
            "hdvb": {},
            "collapse": {
                "url": [
                    "/embed/movie/163"
                ],
                "quality": [
                    "HD (720p)"
                ],
                "duration": [
                    "189 мин. / 03:09"
                ],
                "voice": [
                    "Рус. Дублированный",
                    "Eng.Original"
                ]
            },
            "kodik": {}
        },
        {
            "id": 480006,
            "id_kinopoisk": 1043713,
            "url": "535631-on-vam-ne-dimon-2017",
            "type": "movie",
            "title": "Он вам не Димон",
            "description": "В фильме рассказывается о предполагаемом недвижимом имуществе председателя Правительства Российской Федерации Дмитрия Медведева.",
            "year": 2017,
            "poster": "//images.kinopoisk.cloud/posters/1043713.jpg",
            "countries": [
                "Россия"
            ],
            "genres": [
                "Документальный"
            ],
            "budget": "415000руб.",
            "rating_kinopoisk": "9.072",
            "rating_imdb": "9",
            "kinopoisk_votes": "70677",
            "imdb_votes": "2865",
            "premiere_russia": "2 марта 2017",
            "videocdn": {},
            "hdvb": {},
            "collapse": {},
            "kodik": {}
        },
        {
            "id": 374042,
            "id_kinopoisk": 1048766,
            "url": "370391-dominion-2018",
            "type": "movie",
            "title": "Доминион",
            "title_alternative": "Dominion",
            "description": "Создатели фильма используют беспилотные дроны и скрытые карманные камеры, чтобы разоблачить темное подбрюшье современного животноводства, подвергая сомнению нравственность и обоснованность господства человечества над животным царством.Основное внимание уделяется животным, используемым для производства продуктов питания, но также затрагиваются другие способы, которыми животные эксплуатируются и подвергаются насилию со стороны людей, включая одежду, развлечения и исследования.",
            "year": 2018,
            "poster": "//images.kinopoisk.cloud/posters/1048766.jpg",
            "trailer": "https://www.youtube.com/embed/b9gpKJB4TmM",
            "actors": [
                "Хоакин Феникс",
                "Руни Мара",
                "Сиа",
                "Сэди Синк",
                "Chris Delforce",
                "Кэтрин фон Драхенберг"
            ],
            "countries": [
                "Австралия"
            ],
            "genres": [
                "Документальный"
            ],
            "directors": [
                "Chris Delforce"
            ],
            "screenwriters": [
                "Chris Delforce"
            ],
            "producers": [
                "Chris Delforce",
                "Gary Ash",
                "David Hearne"
            ],
            "composers": [
                "Эшер Поуп"
            ],
            "editors": [
                "Chris Delforce"
            ],
            "rating_kinopoisk": "9.053",
            "rating_imdb": "9.1",
            "kinopoisk_votes": "276",
            "imdb_votes": "1777",
            "premiere_world": "29 марта 2018",
            "videocdn": {},
            "hdvb": {},
            "collapse": {},
            "kodik": {}
        },
        {
            "id": 456236,
            "id_kinopoisk": 1105410,
            "url": "359161-hans-cimmer-live-on-tour-2017",
            "type": "movie",
            "title": "Ханс Циммер: Live on Tour",
            "title_alternative": "Hans Zimmer: Live in Prague",
            "description": "Известный кинокомпозитор Ханс Циммер и его первоклассные музыканты исполнили перед многотысячной публикой знаменитую музыку из голливудских блокбастеров. Это уникальный шанс увидеть художника во всем великолепии его музыкального дара и насладиться прекрасными мелодиями в кругу семьи и друзей.",
            "year": 2017,
            "poster": "//images.kinopoisk.cloud/posters/1105410.jpg",
            "trailer": "https://www.youtube.com/embed/xG59wzLlx6w",
            "age": "зрителям, достигшим 12 лет",
            "actors": [
                "Ханс Циммер",
                "Иоланда Чарльз",
                "Майк Эйнзайгер",
                "Ник Гленни-Смит",
                "Guthrie Govan",
                "Тина Гуо",
                "Ричард Харви",
                "Andrew Kawczynski",
                "Gary Kettel",
                "Lucy Landymore"
            ],
            "countries": [
                "Великобритания"
            ],
            "genres": [
                "Концерт",
                "Музыка",
                "Документальный"
            ],
            "directors": [
                "Тим Ван Сомерен"
            ],
            "producers": [
                "Джереми Азис",
                "Харви Голдсмит",
                "Стивен Кофски"
            ],
            "operators": [
                "Рольф Декенс"
            ],
            "composers": [
                "Ханс Циммер"
            ],
            "editors": [
                "Тим Ван Сомерен"
            ],
            "budget": "€350000",
            "rating_kinopoisk": "9.018",
            "rating_imdb": "9.1",
            "kinopoisk_votes": "384",
            "imdb_votes": "2097",
            "premiere_world": "5 октября 2017",
            "premiere_russia": "22 декабря 2017",
            "frames": [
                "https://st.kp.yandex.net/im/kadr/3/0/8/kinopoisk.ru-Hans-Zimmer_3A-Live-in-Prague-3085082.jpg",
                "https://st.kp.yandex.net/im/kadr/3/0/8/kinopoisk.ru-Hans-Zimmer_3A-Live-in-Prague-3085083.jpg",
                "https://st.kp.yandex.net/im/kadr/3/0/8/kinopoisk.ru-Hans-Zimmer_3A-Live-in-Prague-3085084.jpg",
                "https://st.kp.yandex.net/im/kadr/3/0/8/kinopoisk.ru-Hans-Zimmer_3A-Live-in-Prague-3085085.jpg",
                "https://st.kp.yandex.net/im/kadr/3/0/8/kinopoisk.ru-Hans-Zimmer_3A-Live-in-Prague-3085086.jpg",
                "https://st.kp.yandex.net/im/kadr/3/0/8/kinopoisk.ru-Hans-Zimmer_3A-Live-in-Prague-3085087.jpg",
                "https://st.kp.yandex.net/im/kadr/3/0/8/kinopoisk.ru-Hans-Zimmer_3A-Live-in-Prague-3085088.jpg",
                "https://st.kp.yandex.net/im/kadr/3/0/8/kinopoisk.ru-Hans-Zimmer_3A-Live-in-Prague-3085089.jpg",
                "https://st.kp.yandex.net/im/kadr/3/0/8/kinopoisk.ru-Hans-Zimmer_3A-Live-in-Prague-3085090.jpg",
                "https://st.kp.yandex.net/im/kadr/3/0/8/kinopoisk.ru-Hans-Zimmer_3A-Live-in-Prague-3085091.jpg",
                "https://st.kp.yandex.net/im/kadr/3/0/8/kinopoisk.ru-Hans-Zimmer_3A-Live-in-Prague-3085092.jpg",
                "https://st.kp.yandex.net/im/kadr/3/0/8/kinopoisk.ru-Hans-Zimmer_3A-Live-in-Prague-3085093.jpg"
            ],
            "videocdn": {},
            "hdvb": {},
            "collapse": {},
            "kodik": {}
        },
        {
            "id": 128516,
            "id_kinopoisk": 837982,
            "url": "525630-timeless-2013---le-film-2013",
            "type": "movie",
            "title": "Timeless 2013 - Le film",
            "description": "Живая запись концерта TIMELESS 2013 была сделана во время тура в поддержку одноименного, шестого концертного альбома (и пятнадцатого в общем количестве) в творческой деятельности певицы.",
            "year": 2013,
            "poster": "//images.kinopoisk.cloud/posters/837982.jpg",
            "trailer": "https://www.youtube.com/embed/kt6qlNQtBxc",
            "age": "для любой зрительской аудитории",
            "actors": [
                "Милен Фармер"
            ],
            "countries": [
                "Франция"
            ],
            "genres": [
                "Концерт",
                "Музыка"
            ],
            "directors": [
                "Франсуа Ансс"
            ],
            "budget": "€30000000",
            "rating_kinopoisk": "8.96",
            "kinopoisk_votes": "445",
            "imdb_votes": "195",
            "premiere_russia": "2 апреля 2014",
            "videocdn": {},
            "hdvb": {},
            "collapse": {},
            "kodik": {}
        },
        {
            "id": 511119,
            "id_kinopoisk": 370093,
            "url": "397485-myl-ne-farmer-live-bercy-1997",
            "type": "movie",
            "title": "Mylène Farmer: Live à Bercy",
            "year": 1997,
            "poster": "//images.kinopoisk.cloud/posters/370093.jpg",
            "actors": [
                "Милен Фармер",
                "Валери Бони",
                "Жермен Браун",
                "Айван Кассар",
                "Джефф Дальгрен",
                "Кристоф Даншо",
                "Сьюзи Дэвис",
                "Донна Делори",
                "Эстер Добон&#039; На Эссьенн",
                "Абрахам Лабориэль мл."
            ],
            "countries": [
                "Франция"
            ],
            "genres": [
                "Концерт",
                "Музыка"
            ],
            "directors": [
                "Лоран Бутонна",
                "Франсуа Ансс"
            ],
            "producers": [
                "Тьерри Сюк",
                "Лоран Бутонна"
            ],
            "operators": [
                "Франсуа Ансс"
            ],
            "editors": [
                "Коррадо Эрмано",
                "Николас Трембасьевич"
            ],
            "rating_kinopoisk": "8.94",
            "rating_imdb": "9.1",
            "kinopoisk_votes": "389",
            "imdb_votes": "158",
            "frames": [
                "https://st.kp.yandex.net/im/kadr/2/3/7/kinopoisk.ru-Myl_26egrave_3Bne-Farmer_3A-Live-_26agrave_3B-Bercy-2377535.jpg",
                "https://st.kp.yandex.net/im/kadr/2/3/7/kinopoisk.ru-Myl_26egrave_3Bne-Farmer_3A-Live-_26agrave_3B-Bercy-2377536.jpg",
                "https://st.kp.yandex.net/im/kadr/2/3/7/kinopoisk.ru-Myl_26egrave_3Bne-Farmer_3A-Live-_26agrave_3B-Bercy-2377537.jpg",
                "https://st.kp.yandex.net/im/kadr/2/3/7/kinopoisk.ru-Myl_26egrave_3Bne-Farmer_3A-Live-_26agrave_3B-Bercy-2377538.jpg",
                "https://st.kp.yandex.net/im/kadr/2/3/7/kinopoisk.ru-Myl_26egrave_3Bne-Farmer_3A-Live-_26agrave_3B-Bercy-2377539.jpg"
            ],
            "videocdn": {},
            "hdvb": {},
            "collapse": {},
            "kodik": {}
        },
        {
            "id": 579789,
            "id_kinopoisk": 691558,
            "url": "193532-three-days-grace-live-at-the-palace-2008-2008",
            "type": "movie",
            "title": "Three Days Grace: Live at the Palace 2008",
            "year": 2008,
            "poster": "//images.kinopoisk.cloud/posters/691558.jpg",
            "actors": [
                "Адам Гонтье",
                "Нил Сэндерсон",
                "Бэрри Сток",
                "Three Days Grace",
                "Брэд Уолст"
            ],
            "countries": [
                "США"
            ],
            "genres": [
                "Музыка",
                "Концерт"
            ],
            "directors": [
                "Майкл Драмм"
            ],
            "producers": [
                "Майкл Драмм"
            ],
            "rating_kinopoisk": "8.925",
            "rating_imdb": "8.5",
            "kinopoisk_votes": "120",
            "imdb_votes": "40",
            "premiere_world": "19 августа 2008",
            "videocdn": {},
            "hdvb": {},
            "collapse": {},
            "kodik": {}
        }
    ],
    "pagination": {
        "current_page": "https://api.kinopoisk.cloud/movies/all/page/1/token/bd9529b31886e1c1bdd5e6cfcacba605",
        "end_page": "https://api.kinopoisk.cloud/movies/all/page/59896/token/bd9529b31886e1c1bdd5e6cfcacba605",
        "total_pages": 59896
    }
}
"""