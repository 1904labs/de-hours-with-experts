package com.labs1904

import org.scalatest.FunSpec

class NextBiggestNumberTest extends FunSpec {

  describe("Testing NextBiggestNumber") {

    it("should return the next biggest number for straightforward examples") {
      assert(NextBiggestNumber.getNextBiggestNumber(12) === 21)
      assert(NextBiggestNumber.getNextBiggestNumber(123) === 132)
      assert(NextBiggestNumber.getNextBiggestNumber(67809) === 67890)
    }

    it("should return -1 for straightforward examples") {
      assert(NextBiggestNumber.getNextBiggestNumber(21) === -1)
      assert(NextBiggestNumber.getNextBiggestNumber(54321) === -1)
    }

    it("should work for 52210") {
      assert(NextBiggestNumber.getNextBiggestNumber(52210) === -1)
    }

    it("should work for 95701") {
      assert(NextBiggestNumber.getNextBiggestNumber(95701) === 95710)
    }

    it("should work for 71305") {
      assert(NextBiggestNumber.getNextBiggestNumber(71305) === 71350)
    }

    it("should work for 6358") {
      assert(NextBiggestNumber.getNextBiggestNumber(6358) === 6385)
    }

    it("should work for 25437") {
      assert(NextBiggestNumber.getNextBiggestNumber(25437) === 25473)
    }

    it("should work for 49893") {
      assert(NextBiggestNumber.getNextBiggestNumber(49893) === 49938)
    }

    it("should work for 76778") {
      assert(NextBiggestNumber.getNextBiggestNumber(76778) === 76787)
    }

    it("should work for 2372") {
      assert(NextBiggestNumber.getNextBiggestNumber(2372) === 2723)
    }

    it("should work for 45071") {
      assert(NextBiggestNumber.getNextBiggestNumber(45071) === 45107)
    }

    it("should work for 31233") {
      assert(NextBiggestNumber.getNextBiggestNumber(31233) === 31323)
    }

    it("should work for 50401") {
      assert(NextBiggestNumber.getNextBiggestNumber(50401) === 50410)
    }

    it("should work for 57067") {
      assert(NextBiggestNumber.getNextBiggestNumber(57067) === 57076)
    }

    it("should work for 40272") {
      assert(NextBiggestNumber.getNextBiggestNumber(40272) === 40722)
    }

    it("should work for 54998") {
      assert(NextBiggestNumber.getNextBiggestNumber(54998) === 58499)
    }

    it("should work for 22437") {
      assert(NextBiggestNumber.getNextBiggestNumber(22437) === 22473)
    }

    it("should work for 53510") {
      assert(NextBiggestNumber.getNextBiggestNumber(53510) === 55013)
    }

    it("should work for 78263") {
      assert(NextBiggestNumber.getNextBiggestNumber(78263) === 78326)
    }

    it("should work for 42661") {
      assert(NextBiggestNumber.getNextBiggestNumber(42661) === 46126)
    }

    it("should work for 45118") {
      assert(NextBiggestNumber.getNextBiggestNumber(45118) === 45181)
    }

    it("should work for 26075") {
      assert(NextBiggestNumber.getNextBiggestNumber(26075) === 26507)
    }

    it("should work for 93932") {
      assert(NextBiggestNumber.getNextBiggestNumber(93932) === 99233)
    }

    it("should work for 84252") {
      assert(NextBiggestNumber.getNextBiggestNumber(84252) === 84522)
    }

    it("should work for 33203") {
      assert(NextBiggestNumber.getNextBiggestNumber(33203) === 33230)
    }

    it("should work for 98037") {
      assert(NextBiggestNumber.getNextBiggestNumber(98037) === 98073)
    }

    it("should work for 74041") {
      assert(NextBiggestNumber.getNextBiggestNumber(74041) === 74104)
    }

    it("should work for 11856") {
      assert(NextBiggestNumber.getNextBiggestNumber(11856) === 11865)
    }

    it("should work for 47998") {
      assert(NextBiggestNumber.getNextBiggestNumber(47998) === 48799)
    }

    it("should work for 36708") {
      assert(NextBiggestNumber.getNextBiggestNumber(36708) === 36780)
    }

    it("should work for 93802") {
      assert(NextBiggestNumber.getNextBiggestNumber(93802) === 93820)
    }

    it("should work for 2902") {
      assert(NextBiggestNumber.getNextBiggestNumber(2902) === 2920)
    }

    it("should work for 71116") {
      assert(NextBiggestNumber.getNextBiggestNumber(71116) === 71161)
    }

    it("should work for 76532") {
      assert(NextBiggestNumber.getNextBiggestNumber(76532) === -1)
    }

    it("should work for 81848") {
      assert(NextBiggestNumber.getNextBiggestNumber(81848) === 81884)
    }

    it("should work for 93493") {
      assert(NextBiggestNumber.getNextBiggestNumber(93493) === 93934)
    }

    it("should work for 16332") {
      assert(NextBiggestNumber.getNextBiggestNumber(16332) === 21336)
    }

    it("should work for 97939") {
      assert(NextBiggestNumber.getNextBiggestNumber(97939) === 97993)
    }

    it("should work for 4386") {
      assert(NextBiggestNumber.getNextBiggestNumber(4386) === 4638)
    }

    it("should work for 6950") {
      assert(NextBiggestNumber.getNextBiggestNumber(6950) === 9056)
    }

    it("should work for 92232") {
      assert(NextBiggestNumber.getNextBiggestNumber(92232) === 92322)
    }

    it("should work for 39527") {
      assert(NextBiggestNumber.getNextBiggestNumber(39527) === 39572)
    }

    it("should work for 41766") {
      assert(NextBiggestNumber.getNextBiggestNumber(41766) === 46167)
    }

    it("should work for 3399") {
      assert(NextBiggestNumber.getNextBiggestNumber(3399) === 3939)
    }

    it("should work for 77957") {
      assert(NextBiggestNumber.getNextBiggestNumber(77957) === 77975)
    }

    it("should work for 81899") {
      assert(NextBiggestNumber.getNextBiggestNumber(81899) === 81989)
    }

    it("should work for 2403") {
      assert(NextBiggestNumber.getNextBiggestNumber(2403) === 2430)
    }

    it("should work for 23817") {
      assert(NextBiggestNumber.getNextBiggestNumber(23817) === 23871)
    }

    it("should work for 85520") {
      assert(NextBiggestNumber.getNextBiggestNumber(85520) === -1)
    }

    it("should work for 42882") {
      assert(NextBiggestNumber.getNextBiggestNumber(42882) === 48228)
    }

    it("should work for 56072") {
      assert(NextBiggestNumber.getNextBiggestNumber(56072) === 56207)
    }

    it("should work for 89101") {
      assert(NextBiggestNumber.getNextBiggestNumber(89101) === 89110)
    }

    it("should work for 25384") {
      assert(NextBiggestNumber.getNextBiggestNumber(25384) === 25438)
    }

    it("should work for 54443") {
      assert(NextBiggestNumber.getNextBiggestNumber(54443) === -1)
    }

    it("should work for 49459") {
      assert(NextBiggestNumber.getNextBiggestNumber(49459) === 49495)
    }

    it("should work for 84803") {
      assert(NextBiggestNumber.getNextBiggestNumber(84803) === 84830)
    }

    it("should work for 50766") {
      assert(NextBiggestNumber.getNextBiggestNumber(50766) === 56067)
    }

    it("should work for 43770") {
      assert(NextBiggestNumber.getNextBiggestNumber(43770) === 47037)
    }

    it("should work for 33285") {
      assert(NextBiggestNumber.getNextBiggestNumber(33285) === 33528)
    }

    it("should work for 42083") {
      assert(NextBiggestNumber.getNextBiggestNumber(42083) === 42308)
    }

    it("should work for 47482") {
      assert(NextBiggestNumber.getNextBiggestNumber(47482) === 47824)
    }

    it("should work for 45634") {
      assert(NextBiggestNumber.getNextBiggestNumber(45634) === 45643)
    }

    it("should work for 73784") {
      assert(NextBiggestNumber.getNextBiggestNumber(73784) === 73847)
    }

    it("should work for 97071") {
      assert(NextBiggestNumber.getNextBiggestNumber(97071) === 97107)
    }

    it("should work for 81003") {
      assert(NextBiggestNumber.getNextBiggestNumber(81003) === 81030)
    }

    it("should work for 32619") {
      assert(NextBiggestNumber.getNextBiggestNumber(32619) === 32691)
    }

    it("should work for 36448") {
      assert(NextBiggestNumber.getNextBiggestNumber(36448) === 36484)
    }

    it("should work for 22368") {
      assert(NextBiggestNumber.getNextBiggestNumber(22368) === 22386)
    }

    it("should work for 22794") {
      assert(NextBiggestNumber.getNextBiggestNumber(22794) === 22947)
    }

    it("should work for 58927") {
      assert(NextBiggestNumber.getNextBiggestNumber(58927) === 58972)
    }

    it("should work for 73399") {
      assert(NextBiggestNumber.getNextBiggestNumber(73399) === 73939)
    }

    it("should work for 81830") {
      assert(NextBiggestNumber.getNextBiggestNumber(81830) === 83018)
    }

    it("should work for 49685") {
      assert(NextBiggestNumber.getNextBiggestNumber(49685) === 49856)
    }

    it("should work for 73251") {
      assert(NextBiggestNumber.getNextBiggestNumber(73251) === 73512)
    }

    it("should work for 44595") {
      assert(NextBiggestNumber.getNextBiggestNumber(44595) === 44955)
    }

    it("should work for 81165") {
      assert(NextBiggestNumber.getNextBiggestNumber(81165) === 81516)
    }

    it("should work for 85034") {
      assert(NextBiggestNumber.getNextBiggestNumber(85034) === 85043)
    }

    it("should work for 31814") {
      assert(NextBiggestNumber.getNextBiggestNumber(31814) === 31841)
    }

    it("should work for 79768") {
      assert(NextBiggestNumber.getNextBiggestNumber(79768) === 79786)
    }

    it("should work for 88439") {
      assert(NextBiggestNumber.getNextBiggestNumber(88439) === 88493)
    }

    it("should work for 44697") {
      assert(NextBiggestNumber.getNextBiggestNumber(44697) === 44769)
    }

    it("should work for 52821") {
      assert(NextBiggestNumber.getNextBiggestNumber(52821) === 58122)
    }

    it("should work for 80263") {
      assert(NextBiggestNumber.getNextBiggestNumber(80263) === 80326)
    }

    it("should work for 71049") {
      assert(NextBiggestNumber.getNextBiggestNumber(71049) === 71094)
    }

    it("should work for 91362") {
      assert(NextBiggestNumber.getNextBiggestNumber(91362) === 91623)
    }

    it("should work for 17056") {
      assert(NextBiggestNumber.getNextBiggestNumber(17056) === 17065)
    }

    it("should work for 26130") {
      assert(NextBiggestNumber.getNextBiggestNumber(26130) === 26301)
    }

    it("should work for 83800") {
      assert(NextBiggestNumber.getNextBiggestNumber(83800) === 88003)
    }

    it("should work for 52246") {
      assert(NextBiggestNumber.getNextBiggestNumber(52246) === 52264)
    }

    it("should work for 56996") {
      assert(NextBiggestNumber.getNextBiggestNumber(56996) === 59669)
    }

    it("should work for 30281") {
      assert(NextBiggestNumber.getNextBiggestNumber(30281) === 30812)
    }

    it("should work for 51428") {
      assert(NextBiggestNumber.getNextBiggestNumber(51428) === 51482)
    }

    it("should work for 7654") {
      assert(NextBiggestNumber.getNextBiggestNumber(7654) === -1)
    }

    it("should work for 33095") {
      assert(NextBiggestNumber.getNextBiggestNumber(33095) === 33509)
    }

    it("should work for 50933") {
      assert(NextBiggestNumber.getNextBiggestNumber(50933) === 53039)
    }

    it("should work for 7558") {
      assert(NextBiggestNumber.getNextBiggestNumber(7558) === 7585)
    }

    it("should work for 75659") {
      assert(NextBiggestNumber.getNextBiggestNumber(75659) === 75695)
    }

    it("should work for 36639") {
      assert(NextBiggestNumber.getNextBiggestNumber(36639) === 36693)
    }

    it("should work for 75517") {
      assert(NextBiggestNumber.getNextBiggestNumber(75517) === 75571)
    }

    it("should work for 64149") {
      assert(NextBiggestNumber.getNextBiggestNumber(64149) === 64194)
    }

    it("should work for 44926") {
      assert(NextBiggestNumber.getNextBiggestNumber(44926) === 44962)
    }

    it("should work for 16230") {
      assert(NextBiggestNumber.getNextBiggestNumber(16230) === 16302)
    }

    it("should work for 36166") {
      assert(NextBiggestNumber.getNextBiggestNumber(36166) === 36616)
    }

    it("should work for 14134") {
      assert(NextBiggestNumber.getNextBiggestNumber(14134) === 14143)
    }

    it("should work for 66848") {
      assert(NextBiggestNumber.getNextBiggestNumber(66848) === 66884)
    }

    it("should work for 85420") {
      assert(NextBiggestNumber.getNextBiggestNumber(85420) === -1)
    }

    it("should work for 6447") {
      assert(NextBiggestNumber.getNextBiggestNumber(6447) === 6474)
    }

    it("should work for 70690") {
      assert(NextBiggestNumber.getNextBiggestNumber(70690) === 70906)
    }

    it("should work for 55511") {
      assert(NextBiggestNumber.getNextBiggestNumber(55511) === -1)
    }

    it("should work for 55224") {
      assert(NextBiggestNumber.getNextBiggestNumber(55224) === 55242)
    }

    it("should work for 73239") {
      assert(NextBiggestNumber.getNextBiggestNumber(73239) === 73293)
    }

    it("should work for 21166") {
      assert(NextBiggestNumber.getNextBiggestNumber(21166) === 21616)
    }

    it("should work for 69958") {
      assert(NextBiggestNumber.getNextBiggestNumber(69958) === 69985)
    }

    it("should work for 59609") {
      assert(NextBiggestNumber.getNextBiggestNumber(59609) === 59690)
    }

    it("should work for 28850") {
      assert(NextBiggestNumber.getNextBiggestNumber(28850) === 50288)
    }

    it("should work for 34085") {
      assert(NextBiggestNumber.getNextBiggestNumber(34085) === 34508)
    }

    it("should work for 68686") {
      assert(NextBiggestNumber.getNextBiggestNumber(68686) === 68866)
    }

    it("should work for 30015") {
      assert(NextBiggestNumber.getNextBiggestNumber(30015) === 30051)
    }

    it("should work for 95116") {
      assert(NextBiggestNumber.getNextBiggestNumber(95116) === 95161)
    }

    it("should work for 68150") {
      assert(NextBiggestNumber.getNextBiggestNumber(68150) === 68501)
    }

    it("should work for 80403") {
      assert(NextBiggestNumber.getNextBiggestNumber(80403) === 80430)
    }

    it("should work for 32154") {
      assert(NextBiggestNumber.getNextBiggestNumber(32154) === 32415)
    }

    it("should work for 34731") {
      assert(NextBiggestNumber.getNextBiggestNumber(34731) === 37134)
    }

    it("should work for 18099") {
      assert(NextBiggestNumber.getNextBiggestNumber(18099) === 18909)
    }

    it("should work for 13447") {
      assert(NextBiggestNumber.getNextBiggestNumber(13447) === 13474)
    }

    it("should work for 56296") {
      assert(NextBiggestNumber.getNextBiggestNumber(56296) === 56629)
    }

    it("should work for 1276") {
      assert(NextBiggestNumber.getNextBiggestNumber(1276) === 1627)
    }

    it("should work for 44944") {
      assert(NextBiggestNumber.getNextBiggestNumber(44944) === 49444)
    }

    it("should work for 75519") {
      assert(NextBiggestNumber.getNextBiggestNumber(75519) === 75591)
    }

    it("should work for 45632") {
      assert(NextBiggestNumber.getNextBiggestNumber(45632) === 46235)
    }

    it("should work for 27590") {
      assert(NextBiggestNumber.getNextBiggestNumber(27590) === 27905)
    }

    it("should work for 7251") {
      assert(NextBiggestNumber.getNextBiggestNumber(7251) === 7512)
    }

    it("should work for 90251") {
      assert(NextBiggestNumber.getNextBiggestNumber(90251) === 90512)
    }

    it("should work for 98728") {
      assert(NextBiggestNumber.getNextBiggestNumber(98728) === 98782)
    }

    it("should work for 51811") {
      assert(NextBiggestNumber.getNextBiggestNumber(51811) === 58111)
    }

    it("should work for 59358") {
      assert(NextBiggestNumber.getNextBiggestNumber(59358) === 59385)
    }

    it("should work for 24098") {
      assert(NextBiggestNumber.getNextBiggestNumber(24098) === 24809)
    }

    it("should work for 59176") {
      assert(NextBiggestNumber.getNextBiggestNumber(59176) === 59617)
    }

    it("should work for 54917") {
      assert(NextBiggestNumber.getNextBiggestNumber(54917) === 54971)
    }

    it("should work for 8165") {
      assert(NextBiggestNumber.getNextBiggestNumber(8165) === 8516)
    }

    it("should work for 34178") {
      assert(NextBiggestNumber.getNextBiggestNumber(34178) === 34187)
    }

    it("should work for 71652") {
      assert(NextBiggestNumber.getNextBiggestNumber(71652) === 72156)
    }

    it("should work for 26168") {
      assert(NextBiggestNumber.getNextBiggestNumber(26168) === 26186)
    }

    it("should work for 49396") {
      assert(NextBiggestNumber.getNextBiggestNumber(49396) === 49639)
    }

    it("should work for 78946") {
      assert(NextBiggestNumber.getNextBiggestNumber(78946) === 78964)
    }

    it("should work for 33316") {
      assert(NextBiggestNumber.getNextBiggestNumber(33316) === 33361)
    }

    it("should work for 15484") {
      assert(NextBiggestNumber.getNextBiggestNumber(15484) === 15844)
    }

    it("should work for 2211") {
      assert(NextBiggestNumber.getNextBiggestNumber(2211) === -1)
    }

    it("should work for 97203") {
      assert(NextBiggestNumber.getNextBiggestNumber(97203) === 97230)
    }

    it("should work for 70956") {
      assert(NextBiggestNumber.getNextBiggestNumber(70956) === 70965)
    }

  }
}
