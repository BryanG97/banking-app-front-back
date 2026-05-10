import { ClientVo } from "./client-vo";


export class AccountVo {
    accountId!: number;

    accountNumber!: string;

    accountType!: string;

    accountBeginBalance!: number;

    accountStatus!: boolean;

    client!: ClientVo;

    movementEntities!: any[];
}