import { PersonVo } from "./person-vo";


export class ClientVo{
    clientId!: number;

    clientPassword!: string;

    clientStatus!: boolean;

    person!: PersonVo;
}